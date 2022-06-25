package com.atguigu.springcloud.service;

/**
 * @Author dongzhigang
 * @Date 2022/6/25 21:09
 * @Version 1.0
 * @Description
 */
public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
