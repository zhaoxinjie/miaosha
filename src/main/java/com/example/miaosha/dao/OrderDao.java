package com.example.miaosha.dao;

import com.example.miaosha.model.MSOrder;
import com.example.miaosha.model.Order;
import com.example.miaosha.vo.GoodsVO;
import org.apache.ibatis.annotations.*;

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
public interface OrderDao {

    @Select("select * from ms_order where user_id = #{userId} and goods_id = #{goodsId}")
    public MSOrder getMSOrderByUserIdGoodsId(@Param("userId") Long userId, @Param("goodsId")Long goodsId);


    @Insert("insert into `order` (user_id,goods_id,goods_name,goods_count,goods_price,order_channel,status,create_date) values(" +
            "#{userId},#{goodsId},#{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel}, #{status}, #{createDate})")
    @SelectKey(keyColumn = "id",keyProperty = "id", resultType = long.class, before = false, statement = "select last_insert_id()")
    public long insert(Order order);

    @Insert("insert into ms_order (user_id, goods_id, order_id)values(#{userId}, #{goodsId},#{orderId})")
    public int insertMSOrder(MSOrder msOrder);
}
