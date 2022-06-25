package com.atguigu.springcloud.domain;

import lombok.Data;

/**
 * @Author dongzhigang
 * @Date 2022/6/25 21:06
 * @Version 1.0
 * @Description
 */
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
