package com.netease.sale.service.serviceImpl;

import com.netease.sale.dao.CartDao;
import com.netease.sale.meta.Cart;
import com.netease.sale.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/2/18.
 */
@Service("cartServiceImpl")
public class CartServiceImpl implements CartService {

    @Resource
    private CartDao cartDao;

    @Override
    public Cart selectCart(int keeperId, int goodsId) {
        return cartDao.selectCart(keeperId,goodsId);
    }

    @Override
    public int updateCart(int keepNumber, int cartId) {
        return cartDao.updateCart(keepNumber,cartId);
    }

    @Override
    public int addCart(int keeperId, int goodsId, int keepNumber) {
        return cartDao.addCart(keeperId,goodsId,keepNumber);
    }

    @Override
    public int deleteCart(int keeperId) {
        return cartDao.deleteCart(keeperId);
    }

    @Override
    public int deleteOneCart(int cartId) {
        return cartDao.deleteOneCart(cartId);
    }


}
