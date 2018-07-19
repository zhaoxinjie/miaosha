package com.example.miaosha.service;

import com.example.miaosha.dao.UserDao;
import com.example.miaosha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @file
 * @CopyRight (C) zhaoxinjie2016@gmail.com
 * @brief
 * @author
 * @email 838985328@qq.com
 * @date
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getById(Integer userId){
        return userDao.getById(userId);
    }

}
