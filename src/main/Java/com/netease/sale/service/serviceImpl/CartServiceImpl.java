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
    public void addCart(int keeperId, int goodsId, int keepNumber) {
        cartDao.addCart(keeperId,goodsId,keepNumber);
    }

    @Override
    public void deleteCart(int keeperId, int goodsId) {
        cartDao.deleteCart(keeperId, goodsId);
    }
}
