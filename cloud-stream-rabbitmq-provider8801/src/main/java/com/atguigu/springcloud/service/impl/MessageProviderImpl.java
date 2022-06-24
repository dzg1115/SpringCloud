package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author dongzhigang
 * @Date 2022/6/18 1:34
 * @Version 1.0
 * @Description
 */
@EnableBinding(Source.class) // 可以理解为是一个消息的发送管道的定义
public class MessageProviderImpl implements IMessageProvider{

    @Resource
    private MessageChannel output; // 消息的发送管道

    @Override
    public String send(){

        String uuid = UUID.randomUUID().toString();
        this.output.send(MessageBuilder.withPayload(uuid).build()); // 创建并发送消息
        System.out.println("***uuid: "+uuid);

        return "8801--"+uuid;
    }
}
