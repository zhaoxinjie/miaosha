package com.example.miaosha.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
* @file ValidatorUtil.java 
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:56
*/   
public class ValidatorUtil {

    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String str){
        if (StringUtils.isEmpty(str)){
            return false;
        }

        Matcher m = mobile_pattern.matcher(str);
        return m.matches();
    }

}
