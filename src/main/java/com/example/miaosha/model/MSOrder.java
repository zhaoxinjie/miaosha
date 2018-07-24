package com.example.miaosha.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** 
* @file MSOrder.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:53
*/  
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MSOrder {

    private Long id;
    private Long userId;
    private Long orderId;
    private Long goodsId;

}
