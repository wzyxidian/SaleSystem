package com.netease.sale.web.controller;

import com.netease.sale.meta.Buy;
import com.netease.sale.meta.Cart;
import com.netease.sale.meta.Product;
import com.netease.sale.meta.User;
import com.netease.sale.service.serviceImpl.BuyServiceImpl;
import com.netease.sale.service.serviceImpl.CartServiceImpl;
import com.netease.sale.service.serviceImpl.ProductServiceImpl;
import com.netease.sale.service.serviceImpl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/2/19.
 */
@Controller
public class BuyControl {

    @Resource
    private BuyServiceImpl buyService;
    @Resource
    private CartServiceImpl cartService;
    @Resource
    private UserServiceImpl userService;
    @Resource
    private ProductServiceImpl productService;
    /**
     * 将购物车中购买的信息添加到购买记录表中
     * @param goodsId
     * @param number
     * @param request
     * @return
     */
     @RequestMapping("addBuy")
     public String addBuy(@RequestParam("cartId") int cartId, @RequestParam("goodsId") int goodsId, @RequestParam("number") int number, @RequestParam("oldPrice") double oldPrice, HttpServletRequest request){
//         int buyerId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
         int buyerId = 3;
         cartService.deleteCart(cartId);
         Date date = new Date();
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         String buyTime = simpleDateFormat.format(date);
         buyService.addBuy(buyerId,goodsId,number,buyTime,oldPrice);
         return "index";
     }

    /**
     * 将购物车中的记录都添加到购买表中，同时将购物车中的记录清除掉
     * @param request
     * @return
     */
    @RequestMapping("/addBuyList")
    @ResponseBody
     public String addBuyList(HttpServletRequest request){
         int buyerId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
         User user = userService.showCart(buyerId);
        if(user == null)
            return "fail";
         List<Cart> cartList = user.getCarts();
         List<Buy> buyList = new ArrayList<Buy>();
         List<Product> productSale = new ArrayList<Product>();
         Date date = new Date();
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         String buyTime = simpleDateFormat.format(date);
         for(int i=0;i<cartList.size();i++){
             Buy buy = new Buy();
             buy.setBuyerId(buyerId);
             buy.setBuyTime(buyTime);
             buy.setGoodsId(cartList.get(i).getGoodsId());
             buy.setNumber(cartList.get(i).getKeepNumber());
             buy.setOldPrice(cartList.get(i).getProduct().getPrice());
             buyList.add(buy);

             Product product = new Product();
             product.setProductId(cartList.get(i).getProduct().getProductId());
             product.setSaleout(cartList.get(i).getProduct().getSaleout()+cartList.get(i).getKeepNumber());
             productSale.add(product);
         }
         int buyNum = buyService.addBuyList(buyList);
         int cartNum = 0;
         int prodNum = 0;
         if(buyNum > 0){
             cartNum = cartService.deleteCart(buyerId);
         }
         if(cartNum > 0){
            prodNum = productService.batchUpdateProducts(productSale);
         }
        if(prodNum > 0)
            return "success";
        else
            return "fail";
     }
    /**
     * 列举用户所有购买的商品记录
     * @param request
     * @return
     */
    @RequestMapping("account")
    public ModelAndView buyProductList(HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());

        User user = userService.buyedProductList(userId);
        List<Buy> buyItems = user.getBuys();
        DecimalFormat df = new DecimalFormat("######0.00");
        double result = 0.00;
        for(int i=0;i<buyItems.size();i++){
            result += buyItems.get(i).getOldPrice() * buyItems.get(i).getNumber();
            df.format(result);
        }
        ModelAndView modelAndView = new ModelAndView("productBuyed");
        modelAndView.addObject("buyItems",buyItems);
        modelAndView.addObject("total",result);

//        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}
