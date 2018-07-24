package com.example.miaosha.utils;

import org.apache.commons.codec.digest.DigestUtils;
/** 
* @file MD5Util.java 
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:56
*/  
public class MD5Util {

    private static final String salt = "1a2b3c4d";

    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }

    public static String inputPassFromPass(String inputPass){
        String str = "" + salt.charAt(0) + salt.charAt(3) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String fromPassToDbPass(String inputPass, String salt){
        String str = "" + salt.charAt(0) + salt.charAt(3) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }


    public static String inputPassToDbPass(String inputPass, String dbSalt){
        String formPass = inputPassFromPass(inputPass);
        return fromPassToDbPass(formPass, dbSalt);
    }

    public static void main(String[] args) {
        System.out.println(inputPassToDbPass("1111", "123456"));
    }
}
