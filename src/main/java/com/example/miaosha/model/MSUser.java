package com.example.miaosha.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
* @file
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief
* @author
* @email 838985328@qq.com
* @date
*/

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MSUser {

    private Long id;
    private String nickName;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;

}
