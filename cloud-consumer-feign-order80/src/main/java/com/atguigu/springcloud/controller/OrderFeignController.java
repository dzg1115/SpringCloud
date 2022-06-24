package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @Author dongzhigang
 * @Date 2022/6/12 19:14
 * @Version 1.0
 * @Description
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    //测试OpenFeign的三方调用
    @RequestMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    //测试OpenFeign的超时（默认等待1秒，底层是ribbon）
    @RequestMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeOut();
    }
}
