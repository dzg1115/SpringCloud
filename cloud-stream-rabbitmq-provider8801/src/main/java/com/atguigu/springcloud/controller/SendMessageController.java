package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author dongzhigang
 * @Date 2022/6/18 1:32
 * @Version 1.0
 * @Description
 */
@RestController
public class SendMessageController{

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){

        return messageProvider.send();
    }
}
