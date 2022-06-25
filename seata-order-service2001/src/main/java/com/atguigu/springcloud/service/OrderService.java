package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;

/**
 * @Author dongzhigang
 * @Date 2022/6/25 18:55
 * @Version 1.0
 * @Description
 */
public interface OrderService {

    //创建订单
    void create(Order order);
}
