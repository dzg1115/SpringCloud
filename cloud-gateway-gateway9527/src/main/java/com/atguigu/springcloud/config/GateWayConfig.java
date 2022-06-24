package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author dongzhigang
 * @Date 2022/6/15 1:46
 * @Version 1.0
 * @Description
 */
@Configuration
public class GateWayConfig {

    //不推荐此方式配置网关，推荐使用YML配置文件
//    @Bean
//    public RouteLocator customRouteLocator( RouteLocatorBuilder routeLocatorBuilder){
//
//        RouteLocatorBuilder.Builder routes=routeLocatorBuilder.routes();
//
//        routes.route("path_route_atguigu",
//                r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
//                .build();
//
//        return routes.build();
//    }



}
