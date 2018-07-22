package com.example.miaosha.dao;

import com.example.miaosha.model.MSUser;
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
public interface MSUserDao {

    @Select("select * from ms_user where id = #{id}")
    public MSUser getById(@Param("id") Long id);

}
