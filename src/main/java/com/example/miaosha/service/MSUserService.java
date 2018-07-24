package com.example.miaosha.service;

import com.example.miaosha.dao.MSUserDao;
import com.example.miaosha.exception.GlobalException;
import com.example.miaosha.model.MSUser;
import com.example.miaosha.redis.MSUserKey;
import com.example.miaosha.redis.RedisService;
import com.example.miaosha.result.CodeMessage;
import com.example.miaosha.utils.MD5Util;
import com.example.miaosha.utils.UUIDUtil;
import com.example.miaosha.vo.LoginVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/** 
* @file MSUserService.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:56
*/  

@Service
public class MSUserService {

    public static final String COOKIE_NAME_TOKEN = "token";

    @Resource
    private MSUserDao msUserDao;

    @Resource
    private RedisService redisService;

    public MSUser getById(Long id){
        return msUserDao.getById(id);
    }

    public MSUser getByToken(HttpServletResponse response,String token){
        if (StringUtils.isEmpty(token)){
            return null;
        }

        MSUser user = redisService.get(MSUserKey.token, token, MSUser.class);
        //延长有效期
        if (user != null){
            addCookie(response, token,user);
        }
        return user;
    }

    public boolean login(HttpServletResponse response, LoginVO loginVO){
        if (loginVO == null){
            throw new GlobalException(CodeMessage.SERVER_ERROR);
        }
        String mobile = loginVO.getMobile();
        String formPass = loginVO.getPassword();
        //判断手机号是否存在
        MSUser user = getById(Long.parseLong(mobile));
        if (user == null){
            throw new GlobalException(CodeMessage.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String dbSalt = user.getSalt();
        String calPass = MD5Util.fromPassToDbPass(formPass,dbSalt);
        if (!calPass.equals(dbPass)){
            throw new GlobalException(CodeMessage.PASSWORD_ERROR);
        }
        String token = UUIDUtil.uuid();
        //生成cookie
        addCookie(response,token, user);
        return true;
    }

    private void addCookie(HttpServletResponse response,String token, MSUser user){
        redisService.set(MSUserKey.token, token, user);

        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(MSUserKey.token.getExpireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
