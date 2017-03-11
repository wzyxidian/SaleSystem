package com.netease.sale.meta;

import lombok.Data;

/**
 * Created by Administrator on 2017/2/18.
 */

@Data
public class Cart {

    /**
     * 购物记录ID
     */
    private int cartId;
    /**
     * 买家Id
     */
    private int keeperId;
    /**
     * 商品Id
     */
    private int goodsId;
    /**
     * 购物车中该商品数量
     */
    private int keepNumber;
    /**
     *
     */
    private Product product;
}
