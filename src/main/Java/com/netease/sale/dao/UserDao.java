package com.netease.sale.dao;

import com.netease.sale.meta.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/2/15.
 */
@Repository
public interface UserDao {

    /**
     * 验证用户是否登录成功
     * @param userName 用户名
     * @param userPassword 密码
     * @return
     */
    public User checkUser(@Param("userName") String userName, @Param("userPassword") String userPassword);

    /**
     * 得到用户所有已购买商品
     * @param userId 用户Id，通过session获取
     * @return
     */
    public User buyedProducts(int userId);

    /**
     * 显示用户购物车中的商品
     * @param keeperId
     * @return
     */
    public User showCart(int keeperId);
}
