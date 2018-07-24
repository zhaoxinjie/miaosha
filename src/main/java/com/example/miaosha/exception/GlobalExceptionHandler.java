package com.example.miaosha.exception;

import com.example.miaosha.result.CodeMessage;
import com.example.miaosha.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** 
* @file GlobalExceptionHandler.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:54
*/  
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception ex){
        if(ex instanceof GlobalException){
            GlobalException globalException = (GlobalException) ex;
            return Result.fail(globalException.getCm());
        }else if (ex instanceof BindException){
            BindException be = (BindException) ex;
            List<ObjectError> errors = be.getAllErrors();
            ObjectError objectError = errors.get(0);
            String msg = objectError.getDefaultMessage();
            return Result.fail(CodeMessage.BIND_ERROR.fillArgs(msg));
        }else {
            return Result.fail(CodeMessage.SERVER_ERROR);
        }
    }
}
