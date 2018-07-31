package com.example.miaosha.dao;

import com.example.miaosha.model.MSGoods;
import com.example.miaosha.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/** 
* @file GoodsDao.java
* @CopyRight (C) zhaoxinjie2016@gmail.com
* @brief  
* @author zhao 
* @email 838985328@qq.com 
* @date 2018/7/25-0:53
*/  
@Mapper
public interface GoodsDao {

    @Select("select g.*, mg.stock_count,mg.miaosha_price, mg.start_date, mg.end_date from " +
            "ms_goods mg left join goods g on mg.goods_id = g.id")
    public List<GoodsVO> listGoodsVO();

    @Select("select g.*, mg.stock_count,mg.miaosha_price, mg.start_date, mg.end_date from " +
            "ms_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
    public GoodsVO getGoodsVOByGoodsId(Long goodsId);

    @Update("update ms_goods set stock_count = stock_count - 1 where goods_id = #{id}")
    public int reduceStock(MSGoods g);
}
