package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @Author dongzhigang
 * @Date 2022/6/14 0:21
 * @Version 1.0
 * @Description
 */
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixServiceImpl---paymentInfo_OK--【hystrix服务降级】 ";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentHystrixServiceImpl---paymentInfo_TimeOut--【hystrix服务降级】 ";
    }
}
