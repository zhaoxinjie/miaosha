package com.example.miaosha.controller;

import com.example.miaosha.model.User;
import com.example.miaosha.redis.RedisService;
import com.example.miaosha.redis.UserKey;
import com.example.miaosha.result.Result;
import com.example.miaosha.service.MSUserService;
import com.example.miaosha.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


/** 
* @file LoginController.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:55
*/  
@Controller
@RequestMapping("login")
@Slf4j
public class LoginController {

    @Autowired
    MSUserService msUserService;

    @Autowired
    RedisService redisService;

    @RequestMapping("to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVO loginVO) {
        msUserService.login(response,loginVO);
        //出异常会被捕捉，验证有jsr303验证
        return Result.success(true);

    }


}
