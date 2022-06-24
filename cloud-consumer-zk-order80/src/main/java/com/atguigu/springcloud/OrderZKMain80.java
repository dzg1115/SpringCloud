package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author dongzhigang
 * @Date 2022/6/10 23:31
 * @Version 1.0
 * @Description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderZKMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class,args);

    }

}
