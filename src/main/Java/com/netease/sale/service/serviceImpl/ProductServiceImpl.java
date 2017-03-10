package com.netease.sale.service.serviceImpl;

import com.netease.sale.dao.ProductDao;
import com.netease.sale.meta.Product;
import com.netease.sale.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    @Override
    public List<Product> productList() {
       return  this.productDao.getProductList();
    }

    @Override
    public Product getProduct(int productId) {
        return this.productDao.getProduct(productId);
    }

    @Override
    public void addProduct(String title, String abstracts, String pictrueURL, String detail, int price, int owner) {
        productDao.addProduct(title, abstracts, pictrueURL, detail, price, owner);
    }

    /**
     * 卖家修改一件商品信息
     *
     * @param title
     * @param abstracts
     * @param pictrueURL
     * @param detail
     * @param price
     */
    @Override
    public void updateProduct(int productId, String title, String abstracts, String pictrueURL, String detail, int price) {
        productDao.updateProduct(productId, title, abstracts, pictrueURL, detail, price);
    }

    /**
     * 卖家删除商品
     *
     * @param productId
     */
    @Override
    public void deleteProduct(int productId) {
        productDao.deleteProduct(productId);
    }

    /**
     * 列举出卖家所有的商品
     *
     * @param owner
     */
    @Override
    public List<Product> sellerProductList(int owner) {
        return productDao.sellerProductList(owner);
    }


}
