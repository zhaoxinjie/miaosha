package com.example.miaosha.dao;

import com.example.miaosha.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @file
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author  
* @email 838985328@qq.com 
* @date  
*/
@Mapper
public interface UserDao {

    @Select("select * from t_user where id = #{id}")
    public User getById(@Param("id") Integer id);
}
