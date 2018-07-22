package com.example.miaosha.service;

import com.example.miaosha.dao.MSUserDao;
import com.example.miaosha.exception.GlobalException;
import com.example.miaosha.model.MSUser;
import com.example.miaosha.result.CodeMessage;
import com.example.miaosha.utils.MD5Util;
import com.example.miaosha.vo.LoginVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
* @file
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author  
* @email 838985328@qq.com 
* @date  
*/

@Service
public class MSUserService {

    @Resource
    private MSUserDao msUserDao;

    public MSUser getById(Long id){
        return msUserDao.getById(id);
    }

    public boolean login(LoginVO loginVO){
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
        if (calPass.equals(dbPass)){
            throw new GlobalException(CodeMessage.PASSWORD_ERROR);
        }
        return true;
    }

}
