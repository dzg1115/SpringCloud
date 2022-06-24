package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author dongzhigang
 * @Date 2022/6/12 21:21
 * @Version 1.0
 * @Description  Openfeign 的自定义日志级别
 */
@Configuration
public class FeignConfig{
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}