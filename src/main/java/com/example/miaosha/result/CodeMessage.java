package com.example.miaosha.result;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
/** 
* @file CodeMessage.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:56
*/  
@Getter
@Setter
@EqualsAndHashCode
public class CodeMessage {

    private Integer code;
    private String message;


    //通用的错误码
    public static CodeMessage SUCCESS = new CodeMessage(0, "success");
    public static CodeMessage SERVER_ERROR = new CodeMessage(500100, "服务端异常");
    public static CodeMessage BIND_ERROR = new CodeMessage(500101, "参数校验异常： %s");

    //登录模块
    public static CodeMessage SESSION_ERROR = new CodeMessage(500210, "Session不存在或已失效");
    public static CodeMessage PASSWORD_EMPTY = new CodeMessage(500211, "密码不能为空");
    public static CodeMessage MOBILE_EMPTY = new CodeMessage(500212, "手机号不能为空");
    public static CodeMessage MOBILE_ERROR = new CodeMessage(500213, "手机号错误");
    public static CodeMessage MOBILE_NOT_EXIST = new CodeMessage(500214, "手机号不存在");
    public static CodeMessage PASSWORD_ERROR = new CodeMessage(500215, "密码错误");


    //商品模块5003XX


    //订单模块5004XX

    //秒杀模块5005XX
    public static CodeMessage MIAO_SHA_OVER = new CodeMessage(500500, "商品已经秒杀完毕");
    public static CodeMessage MIAO_SHA_REPEAT = new CodeMessage(500501, "不能重复秒杀");

    private CodeMessage(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public CodeMessage fillArgs(Object...objects){
        int code = this.code;
        String message = String.format(this.message, objects);
        return new CodeMessage(code, message);
    }

}
