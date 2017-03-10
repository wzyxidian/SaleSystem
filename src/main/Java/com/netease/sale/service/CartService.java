package com.netease.sale.service;

import com.netease.sale.meta.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/2/18.
 */
public interface CartService {

    /**
     * 将商品添加到购物车
     * @param keeperId
     * @param goodsId
     * @param keepNumber
     * @return
     */
    public void addCart(int keeperId, int goodsId, int keepNumber);

    /**
     * 将商品从购物车中删除
     * @param keeperId
     * @param goodsId
     */
    public void deleteCart(int keeperId, int goodsId);


}
