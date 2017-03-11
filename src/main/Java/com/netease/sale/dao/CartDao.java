package com.netease.sale.dao;

import com.netease.sale.meta.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/2/18.
 */
@Repository
public interface CartDao {

    /**
     * 将商品添加到购物车中
     * @param keeperId
     * @param goodsId
     * @param keepNumber
     * @return
     */
    public void addCart(@Param("keeperId") int keeperId, @Param("goodsId") int goodsId, @Param("keepNumber") int keepNumber);

    /**
     * 更新购物车中的同一件商品的件数
     * @param keepNumber
     * @param cartId
     */
    public void updateCart(@Param("keepNumber") int keepNumber, @Param("cartId") int cartId);

    /**
     * 删除购物车信息
     * @param keeperId
     * @return
     */
    public int deleteCart(@Param("keeperId") int keeperId);

    /**
     * 查看一条购物车记录
     * @param keeperId
     * @param goodsId
     * @return
     */
    public Cart selectCart(@Param("keeperId") int keeperId, @Param("goodsId") int goodsId);


}
