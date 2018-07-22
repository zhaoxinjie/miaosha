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

import javax.validation.Valid;


/**
 * @author
 * @file
 * @CopyRight (C) zhaoxinjie2016@gmail.com
 * @brief
 * @email 838985328@qq.com
 * @date
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    MSUserService msUserService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(@Valid LoginVO loginVO) {
        msUserService.login(loginVO);
        //出异常会被捕捉，验证有jsr303验证
        return Result.success(true);

    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
        User user = redisService.get(UserKey.getById, "" + 1, User.class);
        return Result.success(user);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        User user = new User();
        user.setId(1);
        user.setName("1111");
        redisService.set(UserKey.getById, "" + 1, user);
        return Result.success(true);
    }

}
