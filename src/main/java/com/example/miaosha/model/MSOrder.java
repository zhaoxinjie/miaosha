package com.example.miaosha.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class MSOrder {

    private Long id;
    private Long userId;
    private Long orderId;
    private Long goodsId;

}
