package com.netease.sale.service;

import com.netease.sale.meta.Product;
import com.netease.sale.meta.User;

import java.util.List;

/**
 * Created by Administrator on 2017/2/18.
 */
public interface UserService {

    /**
     * 检查用户名与密码是否正确
     * @param userName
     * @param userPassword
     * @return
     */
    public User checkUser(String userName, String userPassword);

    /**
     * 得到用户购买的所有的商品
     * @param userId
     * @return
     */
    public User buyedProductList(int userId);

    /**
     * 得到用户未购买的商品列表
     * @param userId
     * @return
     */
    public User unbuyedProductList(int userId);
}
