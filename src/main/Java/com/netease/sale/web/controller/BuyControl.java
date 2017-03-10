package com.netease.sale.web.controller;

import com.netease.sale.meta.Buy;
import com.netease.sale.meta.User;
import com.netease.sale.service.serviceImpl.BuyServiceImpl;
import com.netease.sale.service.serviceImpl.CartServiceImpl;
import com.netease.sale.service.serviceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
    /**
     * 将购物车中购买的信息添加到购买记录表中
     * @param goodsId
     * @param number
     * @param request
     * @return
     */
     @RequestMapping("addBuy")
     public String addBuy(@RequestParam("goodsId") int goodsId, @RequestParam("number") int number, @RequestParam("oldPrice") double oldPrice, HttpServletRequest request){
//         int buyerId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
         int buyerId = 3;
         cartService.deleteCart(buyerId,goodsId);
         Date date = new Date();
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         String buyTime = simpleDateFormat.format(date);
         buyService.addBuy(buyerId,goodsId,number,buyTime,oldPrice);
         return "index";
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
