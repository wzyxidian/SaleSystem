package com.netease.sale.web.controller;

import com.netease.sale.meta.Buy;
import com.netease.sale.meta.Product;
import com.netease.sale.meta.User;
import com.netease.sale.service.serviceImpl.BuyServiceImpl;
import com.netease.sale.service.serviceImpl.CartServiceImpl;
import com.netease.sale.service.serviceImpl.ProductServiceImpl;
import com.netease.sale.service.serviceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
     * 列举买家所有购买的商品记录
     * @param request
     * @return
     */
    @RequestMapping("/account")
    public ModelAndView buyProductList(HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
        User user = userService.buyedProductList(userId);
        ModelAndView modelAndView = new ModelAndView("/productBuyed");
        double result = 0.00;
        if(user != null){
            List<Buy> buyItems = user.getBuys();
            if(buyItems != null && buyItems.size() != 0){
                DecimalFormat df = new DecimalFormat("######0.00");
                for(int i=0;i<buyItems.size();i++){
                    result += buyItems.get(i).getOldPrice() * buyItems.get(i).getNumber();
                    df.format(result);
                }
            }
            modelAndView.addObject("buyItems",buyItems);
            modelAndView.addObject("total",result);
        }
        return modelAndView;
    }

    /**
     * 将购物车中的记录都添加到购买表中，同时将购物车中的记录清除掉
     * @param request
     * @param cartArr 购物车的信息
     * @return
     */
    @RequestMapping("/addBuyList")
    @ResponseBody
     public String addBuyList(HttpServletRequest request, @RequestParam("cartArr") String cartArr){
         String[] cartArray = cartArr.split(";");
         int buyerId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
         List<Buy> buyList = new ArrayList<Buy>();
         List<Product> productSale = new ArrayList<Product>();
         Date date = new Date();
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         String buyTime = simpleDateFormat.format(date);
         for(int i=0;i<cartArray.length;i++){
             Buy buy = new Buy();
             buy.setBuyerId(buyerId);
             buy.setBuyTime(buyTime);
             buy.setGoodsId(Integer.valueOf(cartArray[i].split(",")[0]));
             buy.setNumber(Integer.valueOf(cartArray[i].split(",")[1]));
             buy.setOldPrice(Double.valueOf(cartArray[i].split(",")[2]));
             buyList.add(buy);

             Product product = new Product();
             product.setProductId(Integer.valueOf(cartArray[i].split(",")[0]));
             product.setSaleout(productService.getProduct(Integer.valueOf(cartArray[i].split(",")[0])).getSaleout() + Integer.valueOf(cartArray[i].split(",")[1]));
             productSale.add(product);
         }
         //批量插入购买记录
         int buyNum = buyService.addBuyList(buyList);
         int cartNum = 0;
         int prodNum = 0;
        //批量删除购物车中记录
         if(buyNum > 0){
             cartNum = cartService.deleteCart(buyerId);
         }
         //批量更新商品卖的件数
         if(cartNum > 0){
            prodNum = productService.batchUpdateProducts(productSale);
         }
        if(prodNum > 0)
            return "success";
        else
            return "fail";
     }


}
