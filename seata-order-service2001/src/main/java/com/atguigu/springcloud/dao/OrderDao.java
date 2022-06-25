package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author dongzhigang
 * @Date 2022/6/25 18:32
 * @Version 1.0
 * @Description
 */
@Mapper
public interface OrderDao {

    //创建订单
    void create(Order order);


    //修改订单金额
    void update(@Param("userId") Long userId,@Param("status") Integer status);


}
