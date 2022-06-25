package com.atguigu.springcloud.service;


import com.atguigu.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author dongzhigang
 * @Date 2022/6/25 18:56
 * @Version 1.0
 * @Description  远程调用库存接口
 */
@FeignClient("seata-storage-service")
public interface StorageService {

    //减库存
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
