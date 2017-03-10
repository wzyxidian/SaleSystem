package com.netease.sale.web.controller;

import com.netease.sale.meta.Product;
import com.netease.sale.service.serviceImpl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/2/18.
 */
@Controller
public class ProductInfo {
    @Resource
    private ProductServiceImpl productService;

    /**
     * 得到产品详情
     * @param productId
     * @return
     */
    @RequestMapping("show/productDetail")
    public String showProductDetail(@RequestParam("productId") int productId){
        Product product = productService.getProduct(productId);
        System.out.println(product.getTitle());
        return "productDetail";
    }
}
