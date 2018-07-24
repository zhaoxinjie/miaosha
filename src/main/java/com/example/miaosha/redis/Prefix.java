package com.example.miaosha.redis;
/** 
* @file Prefix.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:54
*/  
public interface Prefix {

    public int getExpireSeconds();

    public String getPrefix();

}
