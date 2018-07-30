package com.example.miaosha.service;

import com.example.miaosha.dao.GoodsDao;
import com.example.miaosha.dao.OrderDao;
import com.example.miaosha.model.Goods;
import com.example.miaosha.model.MSOrder;
import com.example.miaosha.model.MSUser;
import com.example.miaosha.model.Order;
import com.example.miaosha.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/** 
* @file GoodsService.java 
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:55
*/  

@Service
public class MiaoShaService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Transactional
    public Order miaosha(MSUser user, GoodsVO goods){

        goodsService.reduceStock(goods);

        return orderService.createOrder(user, goods);
    }

}
