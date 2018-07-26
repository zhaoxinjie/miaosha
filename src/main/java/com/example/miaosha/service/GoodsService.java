package com.example.miaosha.service;

import com.example.miaosha.dao.GoodsDao;
import com.example.miaosha.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class GoodsService {

    @Resource
    GoodsDao goodsDao;

    public List<GoodsVO> listGoodsVO(){
        return goodsDao.listGoodsVO();
    }

    public GoodsVO getGoodsVOByGoodsId(Long goodsId){
        return goodsDao.getGoodsVOByGoodsId(goodsId);
    }

}
