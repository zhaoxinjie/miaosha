package com.example.miaosha.vo;

import com.example.miaosha.model.Goods;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
* @file GoodsVO.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-23:51
*/

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GoodsVO extends Goods {

    private Integer stockCount;
    private Double miaoshaPrice;
    private Date startDate;
    private Date endDate;
}
