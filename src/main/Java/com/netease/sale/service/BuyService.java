package com.netease.sale.service;

/**
 * Created by Administrator on 2017/2/19.
 */
public interface BuyService {

    public void addBuy(int buyerId, int goodsId, int number, String buyTime);
}
