package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author dongzhigang
 * @Date 2022/6/7 23:20
 * @Version 1.0
 * @Description
 */
//Eureka服务注册中心
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
