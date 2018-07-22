package com.example.miaosha.service;

import com.example.miaosha.dao.UserDao;
import com.example.miaosha.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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

    @Resource
    private UserDao userDao;

    public User getById(Integer userId){
        return userDao.getById(userId);
    }

    @Transactional  //增加事务注解，其中一个失败，其他也回滚
    public Boolean tx(){
        User u1 = new User();
        u1.setId(2);
        u1.setName("222");
        userDao.insert(u1);

        User u2 = new User();
        u2.setId(1);
        u2.setName("111");
        userDao.insert(u2);
        return true;
    }

}
