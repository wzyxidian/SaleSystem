package com.netease.sale.web.controller;

import com.netease.sale.service.serviceImpl.BuyServiceImpl;
import com.netease.sale.service.serviceImpl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/19.
 */
@Controller
public class BuyControl {

    @Resource
    private BuyServiceImpl buyService;
    @Resource
    private CartServiceImpl cartService;

    /**
     * 将购物车中购买的信息添加到购买记录表中
     * @param goodsId
     * @param number
     * @param request
     * @return
     */
     @RequestMapping("/buy/add")
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


}
