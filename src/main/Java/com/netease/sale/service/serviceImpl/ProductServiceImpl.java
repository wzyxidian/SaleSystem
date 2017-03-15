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
    public List<Product> sellerProductList(int owner) {
        return productDao.sellerProductList(owner);
    }

    @Override
    public int deleteProduct(int productId) {
        return productDao.deleteProduct(productId);
    }

    @Override
    public Product getProduct(int productId) {
        return this.productDao.getProduct(productId);
    }

    @Override
    public int addProduct(String title, String abstracts, String pictrueURL, String detail, double price, int owner) {
        return productDao.addProduct(title, abstracts, pictrueURL, detail, price, owner);
    }

    @Override
    public int batchUpdateProducts(List productList) {
        return productDao.batchUpdateProducts(productList);
    }

    @Override
    public List<Product> getProductId(String title, String abstracts, String pictrueURL, String detail, double price, int owner) {
        return productDao.getProductId(title,abstracts,pictrueURL,detail,price,owner);
    }

    @Override
    public int updateProduct(int productId, String title, String abstracts, String pictrueURL, String detail, double price) {
        return productDao.updateProduct(productId, title, abstracts, pictrueURL, detail, price);
    }











}
