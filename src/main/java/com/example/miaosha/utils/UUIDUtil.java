package com.example.miaosha.utils;

import java.util.UUID;

/**
* @file
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author  
* @email 838985328@qq.com 
* @date  
*/  
public class UUIDUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
