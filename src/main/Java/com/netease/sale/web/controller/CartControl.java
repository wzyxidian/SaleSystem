package com.netease.sale.web.controller;

import com.netease.sale.meta.Cart;
import com.netease.sale.meta.User;
import com.netease.sale.service.serviceImpl.CartServiceImpl;
import com.netease.sale.service.serviceImpl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/2/18.
 */
@Controller
public class CartControl {

    @Resource
    private CartServiceImpl cartService;
    @Resource
    private UserServiceImpl userService;
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

    @RequestMapping("/settleAccount")
    public ModelAndView showCart( HttpServletRequest request){
        int keeperId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
        User user = userService.showCart(keeperId);
        List<Cart> cartItems = user.getCarts();
        ModelAndView modelAndView = new ModelAndView("settleAccount");
        modelAndView.addObject("cartItems", cartItems);
        return  modelAndView;
    }
}
