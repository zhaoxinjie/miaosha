package com.example.miaosha.redis;
/**
* @file
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author  
* @email 838985328@qq.com 
* @date  
*/
public interface Prefix {

    public int getExpireSeconds();

    public String getPrefix();

}
