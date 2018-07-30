package com.example.miaosha.controller;

import com.example.miaosha.model.MSOrder;
import com.example.miaosha.model.MSUser;
import com.example.miaosha.model.Order;
import com.example.miaosha.redis.RedisService;
import com.example.miaosha.result.CodeMessage;
import com.example.miaosha.service.GoodsService;
import com.example.miaosha.service.MSUserService;
import com.example.miaosha.service.MiaoShaService;
import com.example.miaosha.service.OrderService;
import com.example.miaosha.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
* @file MiaoShaController.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/27-23:10
*/

@Controller
@RequestMapping("miaosha")
public class MiaoShaController {

    @Autowired
    MSUserService msUserService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoShaService miaoShaService;

    @RequestMapping("do_miaosha")
    public String doMiaosha(Model model, MSUser user,
                          @RequestParam("goodsId")Long goodsId) {
        model.addAttribute("user", user);

        if (user == null){
            return "login";
        }

        //stock judgement
        GoodsVO goods = goodsService.getGoodsVOByGoodsId(goodsId);
        if (goods.getStockCount() <= 0){
            model.addAttribute("errmsg", CodeMessage.MIAO_SHA_OVER.getMessage());
            return "miaosha_fail";
        }

        MSOrder order = orderService.getMSOrderByUserIdGoodsId(user.getId(), goodsId);
        if (order != null){
            model.addAttribute("errmsg", CodeMessage.MIAO_SHA_REPEAT.getMessage());
            return "miaosha_fail";
        }

        //减库存，下订单，写入秒杀订单,事务
        Order orderInfo = miaoShaService.miaosha(user, goods);
        model.addAttribute("orderinfo", orderInfo);
        model.addAttribute("goods", goods);
        return "order_detail";

    }
}
