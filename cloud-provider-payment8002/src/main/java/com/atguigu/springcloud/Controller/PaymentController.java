package com.atguigu.springcloud.Controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author dongzhigang
 * @Date 2022/6/7 0:10
 * @Version 1.0
 * @Description
 */

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody  Payment payment){

        final int result = paymentService.create(payment);
        log.info("****插入的结果****："+result);

        if (result>0){
            return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        final Payment payment = paymentService.getPaymentById(id);
        log.info("****查询的结果****："+payment);

        if (payment != null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应的记录，查询ID："+id,null);
        }

    }

    @GetMapping("/payment/lb")
    public String getPayMentLB(){
        return serverPort;
    }

    //故意写的超时程序，测试feign的超时调用
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        System.out.println("*****paymentFeignTimeOut from port: "+serverPort);
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
