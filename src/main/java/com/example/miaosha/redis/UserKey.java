package com.example.miaosha.redis;


/** 
* @file UserKey.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:55
*/  
public class UserKey extends BasePrefix{

    private UserKey(String prefix) {
        super(prefix);
    }


    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");

    @Override
    public int getExpireSeconds() {
        return 0;
    }
}
