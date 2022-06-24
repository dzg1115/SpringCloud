package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @Author dongzhigang
 * @Date 2022/6/24 2:24
 * @Version 1.0
 * @Description
 */
public class CustomerBlockHandler{
    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler....1");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler.....2");
    }
}
