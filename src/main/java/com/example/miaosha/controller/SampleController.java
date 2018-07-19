package com.example.miaosha.controller;

import com.example.miaosha.model.User;
import com.example.miaosha.result.Result;
import com.example.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author
 * @file
 * @CopyRight (C) zhaoxinjie2016@gmail.com
 * @brief
 * @email 838985328@qq.com
 * @date
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> home() {
        return Result.success("hello, world");
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet(){
        User user= userService.getById(1);
        return Result.success(user);
    }

}
