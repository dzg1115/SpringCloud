package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author dongzhigang
 * @Date 2022/6/16 21:48
 * @Version 1.0
 * @Description
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3355 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class,args);
    }
}
