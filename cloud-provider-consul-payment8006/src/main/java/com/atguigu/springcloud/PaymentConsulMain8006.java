package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author dongzhigang
 * @Date 2022/6/11 14:03
 * @Version 1.0
 * @Description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentConsulMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8006.class,args);
    }

}
