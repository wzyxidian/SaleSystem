package com.netease.sale.dao;

import com.netease.sale.meta.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/2/18.
 */
@Repository
public interface CartDao {

    /**
     * 根据买家Id和商品Id查询该购物记录是否存在
     * @param keeperId
     * @param goodsId
     * @return
     */
    public Cart selectCart(@Param("keeperId") int keeperId, @Param("goodsId") int goodsId);

    /**
     * 更新购物车中的同一件商品的件数
     * @param keepNumber
     * @param cartId
     */
    public int updateCart(@Param("keepNumber") int keepNumber, @Param("cartId") int cartId);

    /**
     * 将商品添加到购物车中
     * @param keeperId
     * @param goodsId
     * @param keepNumber
     * @return
     */
    public int addCart(@Param("keeperId") int keeperId, @Param("goodsId") int goodsId, @Param("keepNumber") int keepNumber);

    /**
     * 删除购物车信息
     * @param keeperId
     * @return
     */
    public int deleteCart(@Param("keeperId") int keeperId);

    /**
     * 删除购物车中的一条记录
     * @param cartId
     * @return
     */
    public int deleteOneCart(@Param("cartId") int cartId);

}
