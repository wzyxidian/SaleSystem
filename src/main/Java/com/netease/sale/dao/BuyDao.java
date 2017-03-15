package com.netease.sale.dao;

import com.netease.sale.meta.Buy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
@Repository
public interface BuyDao {

    /**
     * 同一个用户对同一件商品的购买记录
     * @param buyerId
     * @param goodsId
     * @return
     */
    public List<Buy> getBuys(@Param("buyerId") int buyerId, @Param("goodsId") int goodsId);

    /**
     * 批量将购物车中的信息添加到购买记录表中
     * @param buyList
     * @return
     */
    public int addBuyList(@Param("buyList") List<Buy> buyList);
}
