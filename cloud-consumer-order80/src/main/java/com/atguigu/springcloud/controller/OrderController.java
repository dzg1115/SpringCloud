package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author dongzhigang
 * @Date 2022/6/7 1:51
 * @Version 1.0
 * @Description
 */

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    //自定义负载均衡策略
    @Resource
    private LoadBalancer loadBalancer;

    //获取实例
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayMent(@PathVariable("id") Long id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    // Entities 用法
    @GetMapping("/consumer/payment/createEntities")
    public CommonResult<Payment> create2(Payment payment){

        return restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayMent2(@PathVariable("id") Long id ) {

        ResponseEntity<CommonResult> entity=restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCode()+"\t"+entity.getHeaders()+"\t");
            return  entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }

    //自定义负载均衡
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){

        //从注册中心发现服务
        List<ServiceInstance> instancesList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        System.out.println("\n"+"CLOUD-PAYMENT-SERVICE 下面共有："+instancesList.size()+"个服务，分别是：");
        for (int i = 0; i < instancesList.size(); i++) {
            System.out.println(instancesList.get(i).getInstanceId());
        }
        if(instancesList==null ||instancesList.size() <=0){
            return null;
        }else {
            //轮询返回集合中的服务（payment8001、payment8002），实现负载均衡
            ServiceInstance serviceInstance=loadBalancer.getInstances(instancesList);
            URI uri=serviceInstance.getUri();
            return restTemplate.getForObject(uri+"/payment/lb",String.class);
        }

    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }


}
