package com.example.miaosha.result;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/** 
* @file Result.java 
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:55
*/  

@Getter
@Setter
@EqualsAndHashCode
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data){
        return new Result<>(data);
    }

    public static <T> Result<T> fail(CodeMessage cm){
        return new Result(cm);
    }

    private Result(T data){
        this.code = 0;
        this.message = "success";
        this.data = data;
    }

    private Result(CodeMessage cm){
        if (cm == null){
            return;
        }
        this.code = cm.getCode();
        this.message = cm.getMessage();
    }

}
