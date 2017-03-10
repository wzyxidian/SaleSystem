package com.netease.sale.service.serviceImpl;

import com.netease.sale.dao.UserDao;
import com.netease.sale.meta.Product;
import com.netease.sale.meta.User;
import com.netease.sale.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/18.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;


    @Override
    public User checkUser(String userName, String userPassword) {
       return userDao.checkUser(userName,userPassword);
    }

    @Override
    public User buyedProductList(int userId) {

        return userDao.buyedProducts(userId);
    }

    @Override
    public User unbuyedProductList(int userId) {
        return userDao.unbuyedProducts(userId);
    }

    /**
     * 显示用户购物车中的商品
     *
     * @param keeperId
     * @return
     */
    @Override
    public User showCart(int keeperId) {
        return userDao.showCart(keeperId);
    }
}
