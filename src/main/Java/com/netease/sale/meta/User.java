package com.netease.sale.meta;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */

@Data
public class User {
    /**
     * 用户ID，包括卖家和买家
     */
    private int userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户加密之后的密码
     */
    private String userPassword;
    /**
     * 区分卖家与买家的标签
     */
    private int flag;
    /**
     * 买家有很多购买记录
     */
    private List<Buy> buys;
    /**
     * 买家有很多购物车记录
     */
    private List<Cart> carts;
}
