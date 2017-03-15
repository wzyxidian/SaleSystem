package com.netease.sale.service;

import com.netease.sale.meta.Cart;

/**
 * Created by Administrator on 2017/2/18.
 */
public interface CartService {

    /**
     * 根据买家Id和商品Id查询该购物记录是否存在
     * @param keeperId
     * @param goodsId
     * @return
     */
    public Cart selectCart(int keeperId, int goodsId);

    /**
     * 更新购物车中同一件商品的件数
     * @param keepNumber
     * @param cartId
     */
    public int updateCart(int keepNumber, int cartId);

    /**
     * 将商品添加到购物车
     * @param keeperId
     * @param goodsId
     * @param keepNumber
     * @return
     */
    public int addCart(int keeperId, int goodsId, int keepNumber);

    /**
     * 将商品从购物车中删除
     * @param keeperId
     */
    public int deleteCart(int keeperId);

    /**
     * 删除购物车中的一条记录
     * @param cartId
     * @return
     */
    public int deleteOneCart(int cartId);

}
