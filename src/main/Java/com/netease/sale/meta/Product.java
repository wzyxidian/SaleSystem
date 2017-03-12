package com.netease.sale.meta;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Time;

/**
 * Created by Administrator on 2017/2/15.
 */
@Data
public class Product {
    /**
     * 商品ID
     */
    private int productId;
    /**
     * 商品的标题
     */
    private String title;
    /**
     * 商品的摘要
     */
    private String abstracts;
    /**
     * 商品图片的地址
     */
    private String pictureURL;
    /**
     * 商品的详情
     */
    private String detail;
    /**
     * 商品的价格
     */
    private double price;
    /**
     * 商品所属的卖家ID
     */
    private int owner;
    /**
     * 商品是否售出
     */
    private int saleout;
}
