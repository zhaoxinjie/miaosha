package com.example.miaosha.utils;

import org.apache.commons.codec.digest.DigestUtils;

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
        System.out.println(inputPassFromPass("123456"));
    }
}
