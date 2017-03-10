package com.netease.sale.dao;

import com.netease.sale.meta.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
@Repository
public interface ProductDao {

    /**
     * 得到商品的详情
     * @param productId
     * @return
     */
    public Product getProduct(int productId);

    /**
     * 得到所有的商品
     * @return
     */
    public List<Product> getProductList();

    /**
     * 发布一件商品
     * @param title
     * @param abstracts
     * @param pictureURL
     * @param detail
     * @param price
     * @param owner
     */
    public void addProduct(@Param("title") String title, @Param("abstracts") String abstracts, @Param("pictureURL") String pictureURL, @Param("detail") String detail, @Param("price") int price, @Param("owner") int owner);

    /**
     * 卖家修改一件商品的信息
     * @param title
     * @param abstracts
     * @param pictureURL
     * @param detail
     * @param price
     */
    public void updateProduct(@Param("productId") int productId, @Param("title") String title, @Param("abstracts") String abstracts, @Param("pictureURL") String pictureURL, @Param("detail") String detail, @Param("price") int price);

    /**
     * 卖家删除商品
     * @param productId
     */
    public void deleteProduct(int productId);

    /**
     * 列举出卖家所有的商品
     * @param owner
     * @return
     */
    public List<Product> sellerProductList(int owner);
}
