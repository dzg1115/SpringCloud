package com.atguigu.springcloud.service.impl;

/**
 * @Author dongzhigang
 * @Date 2022/6/25 21:21
 * @Version 1.0
 * @Description
 */

import com.atguigu.springcloud.dao.AccountDao;
import com.atguigu.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 账户业务实现类
 * Created by zzyy on 2019/11/11.
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {


    @Resource
    AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        int age=10/0;
        accountDao.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");
    }
}