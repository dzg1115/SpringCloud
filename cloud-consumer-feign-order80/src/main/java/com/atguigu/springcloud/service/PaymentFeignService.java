package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author dongzhigang
 * @Date 2022/6/12 19:03
 * @Version 1.0
 * @Description
 */
@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //粘贴 payment8001 的controller，本来是粘贴dao接口，为了理解方便粘贴controller
    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeOut();

}
