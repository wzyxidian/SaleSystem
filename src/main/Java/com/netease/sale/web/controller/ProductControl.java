package com.netease.sale.web.controller;

import com.netease.sale.meta.Buy;
import com.netease.sale.meta.Product;
import com.netease.sale.meta.User;
import com.netease.sale.service.serviceImpl.ProductServiceImpl;
import com.netease.sale.service.serviceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/19.
 */
@Controller
public class ProductControl {
    @Resource
    private ProductServiceImpl productService;
    @Resource
    private UserServiceImpl userService;
    /**
     * 发布商品
     * @param title
     * @param abstracts
     * @param pictureURL
     * @param detail
     * @param price
     * @param request
     * @return
     */
    @RequestMapping("product/add")
    public String  addProduct(@RequestParam("title") String title,
                           @RequestParam("abstracts") String abstracts,
                           @RequestParam("pictureURL") String pictureURL,
                           @RequestParam("detail") String detail,
                           @RequestParam("price") int price,
                           HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
//        int userId = 3;
        productService.addProduct(title,abstracts,pictureURL,detail,price,userId);
        return "index";
    }

    /**
     * 更新商品信息
     * @param productId
     * @param title
     * @param abstracts
     * @param pictureURL
     * @param detail
     * @param price
     * @param request
     * @return
     */
    @RequestMapping("product/update")
    public String updateProduct(@RequestParam("productId") int productId,
                                @RequestParam("title") String title,
                                @RequestParam("abstracts") String abstracts,
                                @RequestParam("pictureURL") String pictureURL,
                                @RequestParam("detail") String detail,
                                @RequestParam("price") int price,
                                HttpServletRequest request){
        productService.updateProduct(productId,title,abstracts,pictureURL,detail,price);
        return "index";
    }

    /**
     * 删除商品
     * @param productId
     * @return
     */
    @RequestMapping("/delete")
    public String deleteProduct(@RequestParam("productId") int productId){
        System.out.println("删除没有买的消息");
        productService.deleteProduct(productId);
        return "redirect:/index";
    }

    /**
     * 得到卖家自己的商品列表,并标明已经售出商品
     * @param request
     * @return
     */
    @RequestMapping("seller")
    public String sellerProductList(HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
//        int userId = 1;
        List<Product> productList = productService.sellerProductList(userId);
        System.out.println(productList.size());
        return "index";
    }

    /**
     * 首页面所有商品展示
     * @throws IOException
     */
    @RequestMapping("/index")
    public ModelAndView productList(HttpServletRequest request) throws IOException{
        ModelAndView modelAndView = new ModelAndView();

        List<Product> products = productService.productList();
        System.out.println("当前共有： " + products.size() + "  件产品");
        modelAndView.addObject("productList", products);

        if(request.getSession().getAttribute("userId") != null
                && (Integer)(request.getSession().getAttribute("flag")) == 0){
            int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
            User user = userService.buyedProductList(userId);
            List<Buy> buyItems = user.getBuys();
            System.out.println("购买记录条数：" + buyItems.size());
            Set<Product> buyProducts = new HashSet<Product>();
            Set<Product> unbuyProducts = new HashSet<Product>();
            for (int i=0;i<buyItems.size();i++) {
                buyProducts.add(buyItems.get(i).getProduct());
            }
            for(int i=0;i<products.size();i++){
                if(!buyProducts.contains(products.get(i))){
                    unbuyProducts.add(products.get(i));
                }
            }
            modelAndView.addObject("buyProducts",buyProducts);
            modelAndView.addObject("unbuyProducts",unbuyProducts);
            System.out.println("购买商品种类数：" + buyProducts.size());
        }else if(request.getSession().getAttribute("userId") != null
                && (Integer)(request.getSession().getAttribute("flag")) == 1){
            int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
            List<Product> sellerProductList = productService.sellerProductList(userId);
            System.out.println("卖家共有商品数：" + sellerProductList.size());
            List<Product> saleProducts = new ArrayList<Product>();
            for(Product product : sellerProductList){
                if(product.getSaleout() > 0){
                    saleProducts.add(product);
                }
            }
            System.out.println("卖家已卖出商品数：" + saleProducts.size());
            modelAndView.addObject("sellerProductList", sellerProductList);
            modelAndView.addObject("saleProducts", saleProducts);
        }
        modelAndView.setViewName("index");//跳转到指定的页面
        return modelAndView;
    }

    /**
     * 得到产品详情
     * @param productId
     * @return
     */
    @RequestMapping("/productDetail")
    public ModelAndView showProductDetail(@RequestParam("productId") int productId){
        Product product = productService.getProduct(productId);
        System.out.println("产品名称:" + product.getTitle());
        ModelAndView modelAndView = new ModelAndView("productDetail");
        modelAndView.addObject("productDetail", product);
        return  modelAndView;
    }

    /**
     * 列举用户所有购买的商品
     * @param request
     * @return
     */
    @RequestMapping("showBuy")
    public ModelAndView buyProductList(HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());

        User user = userService.buyedProductList(userId);
        List<Buy> buyItems = user.getBuys();
        System.out.println("购买记录条数：" + buyItems.size());
        Set<Integer> buyProducts = new HashSet<Integer>();
        for (int i=0;i<buyItems.size();i++) {
            buyProducts.add(buyItems.get(i).getProduct().getProductId());
        }
        System.out.println("购买商品种类数：" + buyProducts.size());

        ModelAndView modelAndView;
        modelAndView = new ModelAndView("redirect:/");//两种重定向的方法都可以
        modelAndView.addObject("buyProducts",buyProducts);

//        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    /**
     * 列举用户所有购买的商品
     * @param request
     * @return
     */
    @RequestMapping("showUnbuy")
    public ModelAndView unbuyProductList(HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());

        User user = userService.unbuyedProductList(userId);
        List<Buy> unbuyItems = user.getBuys();
        Set<Product> unbuyProducts = new HashSet<Product>();
        for (int i=0;i<unbuyItems.size();i++) {
            unbuyProducts.add(unbuyItems.get(i).getProduct());
        }
        System.out.println("未购买商品种类数：" + unbuyProducts.size());

        ModelAndView modelAndView;
        modelAndView = new ModelAndView("/index");//两种重定向的方法都可以
        modelAndView.addObject("unbuyProducts",unbuyProducts);

//        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
