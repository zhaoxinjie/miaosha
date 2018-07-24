package com.example.miaosha.redis;

/** 
* @file BasePrefix.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:55
*/  


public abstract class BasePrefix implements Prefix{

    private int expireSeconds;

    private String prefix;

    public BasePrefix(String prefix){
        this(0,prefix);
    }


    public BasePrefix(int expireSeconds, String prefix){
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int getExpireSeconds() { //默认0代表永不过期
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
