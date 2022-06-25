package com.atguigu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author dongzhigang
 * @Date 2022/6/25 18:13
 * @Version 1.0
 * @Description  数据统一封装返回
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{

    private Integer code;
    private String  message;
    private T       data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

}
