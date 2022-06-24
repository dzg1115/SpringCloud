package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author dongzhigang
 * @Date 2022/6/12 15:46
 * @Version 1.0
 * @Description  自定义负载均衡
 */
@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    //通过自旋锁，获取当前访问的次数
    public final int getAndIncrement(){
        int current;
        int next;
        //自旋锁
        do{
            current=this.atomicInteger.get();
            next=current > 2147483647 ? 0:current+1;

        } while(!this.atomicInteger.compareAndSet(current,next));

        System.out.println("****访问次数next为: "+next);
        return next;
    }

    //通过下标，返回被访问实例 （ServiceInstance=系统中服务的实例：payment8001,payment8002）
    @Override
    public ServiceInstance getInstances(List serviceInstances) {
        //获取下标 （index=访问次数 % 服务集群数量 =2）
        int index=getAndIncrement() % serviceInstances.size();
        //通过下标，获取集合中的实例
        ServiceInstance instance = (ServiceInstance) serviceInstances.get(index);
        System.out.println("****此次访问的instance为："+instance.getInstanceId()+"\t"+instance.getUri());
        return instance;
    }
}
