package com.example.miaosha.vo;
/** 
* @file
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author  
* @email 838985328@qq.com 
* @date  
*/  

import com.example.miaosha.validator.IsMobile;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LoginVO {

    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;
}
