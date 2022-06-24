package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dongzhigang
 * @Date 2022/6/16 21:50
 * @Version 1.0
 * @Description
 */
@RestController
@RefreshScope  //刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }


}
