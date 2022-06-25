package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author dongzhigang
 * @Date 2022/6/25 18:58
 * @Version 1.0
 * @Description
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    //创建订单（下订单->减库存->减余额->改状态） 分布式事务
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class) //分布式，全局事务控制
    public void create(Order order) {

        //1、下订单
        log.info("--->下单开始");
        orderDao.create(order);

        //2、减库存
        log.info("--->减库存开始");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("--->减库存结束");

        //3、减余额
        log.info("--->减余额开始");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("--->减余额结束");

        //4、改状态
        log.info("--->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("--->修改订单状态结束");

        log.info("--->下单结束，成功！");

    }



}
