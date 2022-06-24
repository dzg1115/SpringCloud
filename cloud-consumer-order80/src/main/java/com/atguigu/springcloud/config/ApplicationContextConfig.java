package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author dongzhigang
 * @Date 2022/6/7 19:43
 * @Version 1.0
 * @Description
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced   //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
