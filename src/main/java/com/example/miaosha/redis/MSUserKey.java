package com.example.miaosha.redis;

/** 
* @file MSUserKey.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:56
*/  
public class MSUserKey extends BasePrefix{

    private static int TOKEN_EXPIRE = 3600*24*2;

    private MSUserKey(int expire,String prefix) {
        super(TOKEN_EXPIRE,prefix);
    }

    public static MSUserKey token = new MSUserKey(TOKEN_EXPIRE,"tk");

}
