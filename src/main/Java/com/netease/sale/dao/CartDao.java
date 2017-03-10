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
     * 将商品添加到购物车中
     * @param keeperId
     * @param goodsId
     * @param keepNumber
     * @return
     */
    public void addCart(@Param("keeperId") int keeperId, @Param("goodsId") int goodsId, @Param("keepNumber") int keepNumber);

    /**
     * 删除购物车信息
     * @param keeperId
     * @return
     */
    public void deleteCart(@Param("keeperId") int keeperId, @Param("goodsId") int goodsId);
}
