package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author dongzhigang
 * @Date 2022/6/25 18:57
 * @Version 1.0
 * @Description  远程调用账户余额接口
 */
@FeignClient("seata-account-service")
public interface AccountService {

    //减余额
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
