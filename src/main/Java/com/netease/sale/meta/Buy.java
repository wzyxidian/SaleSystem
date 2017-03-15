package com.netease.sale.meta;

import lombok.Data;

/**
 * Created by Administrator on 2017/2/15.
 */

@Data
public class Buy {

    /**
     * 购买记录ID
     */
    private int buyId;
    /**
     * 买家ID
     */
    private int buyerId;
    /**
     * 买家购买的商品ID
     */
    private int goodsId;
    /**
     * 买家购买该商品的件数
     */
    private int number;
    /**
     * 购买时间
     */
    private String buyTime;
    /**
     * 一条购买记录对应一件商品
     */
    private Product product;
    /**
     * 购买商品时的价格
     */
    private Double oldPrice;
}
