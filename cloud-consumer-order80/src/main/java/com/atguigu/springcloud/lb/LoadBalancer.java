package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author dongzhigang
 * @Date 2022/6/12 15:43
 * @Version 1.0
 * @Description
 */
public interface LoadBalancer{
    //获取负载后的服务实例 (payment8001 或 payment8002)
    ServiceInstance getInstances(List serviceInstances);
}
