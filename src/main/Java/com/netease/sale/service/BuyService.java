package com.netease.sale.service;

import com.netease.sale.meta.Buy;

import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */
public interface BuyService {

    /**
     *  同一个用户对同一件商品的购买记录
     * @param buyerId
     * @param goodsId
     * @return
     */
    public List<Buy> getBuys(int buyerId, int goodsId);

    /**
     * 将购物车中的记录批量添加到购买记录表中
     * @param buyList
     * @return
     */
    public int addBuyList(List<Buy> buyList);
}
