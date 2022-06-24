package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author dongzhigang
 * @Date 2022/6/11 15:37
 * @Version 1.0
 * @Description
 */
@RestController
@Slf4j
public class OrderController {

    public static final String INVOKE_URL="http://cloud-providerconsul-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String payMentInfo(){

        final String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }





}
