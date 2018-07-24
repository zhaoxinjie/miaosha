package com.example.miaosha.controller;

import com.example.miaosha.model.MSUser;
import com.example.miaosha.redis.RedisService;
import com.example.miaosha.service.MSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
* @file
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author  
* @email 838985328@qq.com 
* @date  
*/
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    MSUserService msUserService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_list")
    public String toLogin(Model model,MSUser user) {
        model.addAttribute("user", user);
        return "goods_list";
    }

    @RequestMapping("/to_detail")
    public String toDetail(HttpServletResponse response,Model model,
                          @CookieValue(value = MSUserService.COOKIE_NAME_TOKEN, required = false) String cookieToken,
                          @RequestParam(value = MSUserService.COOKIE_NAME_TOKEN, required = false) String paramToken) {

        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)){
            return "login";
        }
        String token = StringUtils.isEmpty(paramToken)? cookieToken : paramToken;
        MSUser user = msUserService.getByToken(response, token);
        model.addAttribute("user", user);
        return "goods_list";
    }
}
