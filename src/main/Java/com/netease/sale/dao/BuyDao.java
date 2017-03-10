package com.netease.sale.dao;

import com.netease.sale.meta.Buy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
@Repository
public interface BuyDao {

    /**
     * 将购物车中购买后的商品添加到购买记录表中
     * @param buyerId
     * @param goodsId
     * @param number
     * @param buyTime
     * @return
     */
    public void addBuy(@Param("buyerId") int buyerId, @Param("goodsId") int goodsId, @Param("number") int number, @Param("buyTime") String buyTime, @Param("oldPrice") Double oldPrice);

    /**
     * 查询用户购买记录简要信息
     * @param buyerId
     * @param goodsId
     * @return
     */
    public List<Buy> getBuys(@Param("buyerId") int buyerId, @Param("goodsId") int goodsId);
}
