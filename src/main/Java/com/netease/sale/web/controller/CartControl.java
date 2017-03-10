package com.netease.sale.web.controller;

import com.netease.sale.meta.Cart;
import com.netease.sale.service.serviceImpl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/2/18.
 */
@Controller
public class CartControl {

    @Resource
    private CartServiceImpl cartService;

    /**
     * 添加购物车
     * @param goodsId
     * @param keepNumber
     * @param request
     * @return
     */
    @RequestMapping("/cart/add")
    public String addCart(@RequestParam("goodsId") int goodsId, @RequestParam("keepNumber") int keepNumber, HttpServletRequest request){
       //int keeperId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
        int keeperId = 3;
        cartService.addCart(keeperId, goodsId, keepNumber);
        return "productDetail";
    }

  /*  @RequestMapping("/cart/delete")
    public String deleteCart(@RequestParam("goodsId") int goodsId, HttpServletRequest request){
        //int keeperId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
        int keeperId = 3;
        cartService.deleteCart(keeperId, goodsId);
        return "index";
    }*/
}
