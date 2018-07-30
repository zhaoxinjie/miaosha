package com.example.miaosha.service;

import com.example.miaosha.dao.GoodsDao;
import com.example.miaosha.dao.OrderDao;
import com.example.miaosha.model.MSOrder;
import com.example.miaosha.model.MSUser;
import com.example.miaosha.model.Order;
import com.example.miaosha.vo.GoodsVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
public class OrderService {

    @Resource
    OrderDao orderDao;

    public MSOrder getMSOrderByUserIdGoodsId(Long userId, Long goodsId){
        return orderDao.getMSOrderByUserIdGoodsId(userId, goodsId);
    }

    @Transactional
    public Order createOrder(MSUser user, GoodsVO goods){
        Order orderInfo = new Order();
        orderInfo.setCreateDate(new Date());
        orderInfo.setDeliveryAddrId(0l);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setGoodsName(goods.getGoodsName());
        orderInfo.setGoodsPrice(goods.getMiaoshaPrice());
        orderInfo.setOrderChannel(1);
        orderInfo.setStatus(0);
        orderInfo.setUserId(user.getId());
        long orderId = orderDao.insert(orderInfo);

        MSOrder msOrder = new MSOrder();
        msOrder.setGoodsId(goods.getId());
        msOrder.setOrderId(orderId);
        msOrder.setUserId(user.getId());

        orderDao.insertMSOrder(msOrder);


        return orderInfo;
    }

}
