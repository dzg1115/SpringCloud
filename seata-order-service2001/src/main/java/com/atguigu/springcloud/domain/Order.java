package com.atguigu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * @Author dongzhigang
 * @Date 2022/6/25 18:13
 * @Version 1.0
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order{

    //主键
    private Long id;

    //用户id
    private Long userId;

    //产品id
    private Long productId;

    //产品数量
    private Integer count;

    //产品金额
    private BigDecimal money;

    //订单状态：0：创建中；1：已完结
    private Integer status;

}
