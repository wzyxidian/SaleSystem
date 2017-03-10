package com.netease.sale.service;

import com.netease.sale.dao.ProductDao;
import com.netease.sale.dao.UserDao;
import com.netease.sale.meta.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */

public interface ProductService {

    /**
     * 得到所有的商品信息
     * @return
     */
    public List<Product> productList();

    /**
     * 得到一件商品的详情
     * @param productId
     * @return
     */
    public Product getProduct(int productId);

    /**
     * 卖家发布一件产品
     * @param title
     * @param abstracts
     * @param pictrueURL
     * @param detail
     * @param price
     * @param owner
     */
    public void addProduct(String title, String abstracts, String pictrueURL, String detail, int price, int owner);

    /**
     * 卖家修改一件商品信息
     * @param title
     * @param abstracts
     * @param pictrueURL
     * @param detail
     * @param price
     */
    public void updateProduct(int productId, String title, String abstracts, String pictrueURL, String detail, int price);

    /**
     * 卖家删除商品
     * @param productId
     */
    public void deleteProduct(int productId);

    /**
     * 列举出卖家所有的商品
     * @param owner
     */
    public List<Product> sellerProductList(int owner);
}