package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dongzhigang
 * @Date 2022/6/17 0:28
 * @Version 1.0
 * @Description
 */
@RestController
@RefreshScope
public class ConfigClientController{

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String configInfo(){

        return "serverPort: "+serverPort+"\t\n\n configInfo: "+configInfo;
    }

}