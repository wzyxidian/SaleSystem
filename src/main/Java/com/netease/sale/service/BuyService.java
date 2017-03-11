package com.netease.sale.service;

import com.netease.sale.meta.Buy;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */
public interface BuyService {

    public void addBuy(int buyerId, int goodsId, int number, String buyTime, double oldPrice);

    public List<Buy> getBuys(int buyerId, int goodsId);

    /**
     * 将购物车中的记录批量添加到购买记录表中
     * @param buyList
     * @return
     */
    public int addBuyList(List<Buy> buyList);
}
