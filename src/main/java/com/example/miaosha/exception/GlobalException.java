package com.example.miaosha.exception;

import com.example.miaosha.result.CodeMessage;
import lombok.Getter;
/** 
* @file GlobalException.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:54
*/  
@Getter
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 899648741060478206L;

    private CodeMessage cm;

    public GlobalException(CodeMessage cm){
        this.cm = cm;
    }
}
