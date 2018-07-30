package com.example.miaosha.controller;

import com.example.miaosha.model.MSUser;
import com.example.miaosha.redis.RedisService;
import com.example.miaosha.service.GoodsService;
import com.example.miaosha.service.MSUserService;
import com.example.miaosha.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/** 
* @file GoodsController.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:55
*/  
@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    MSUserService msUserService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("to_list")
    public String toLogin(Model model,MSUser user) {
        model.addAttribute("user", user);
        //query goods list
        List<GoodsVO> goodsList = goodsService.listGoodsVO();
        model.addAttribute("goodsList", goodsList);


        return "goods_list";
    }

    @RequestMapping("to_detail/{goodsId}")
    public String toDetail(Model model, MSUser user,
                           @PathVariable("goodsId") Long goodsId) {
        //snowflake 非自增id，防止人
        model.addAttribute("user", user);

        GoodsVO goods = goodsService.getGoodsVOByGoodsId(goodsId);
        model.addAttribute("goods", goods);
        long startAt = goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int msStatus = 0;
        int remainSeconds = 0;

        if (now < startAt){
            msStatus = 0;
            remainSeconds = (int)(startAt-now)/1000;
        }else if (now > endAt){
            msStatus = 2;
            remainSeconds = -1;
        }else {
            msStatus = 1;
            remainSeconds = 0;
        }

        model.addAttribute("miaoshaStatus", msStatus);
        model.addAttribute("remainSeconds", remainSeconds);

        return "goods_detail";
    }
}
