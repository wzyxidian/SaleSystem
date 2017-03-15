package com.netease.sale.web.controller;

import com.netease.sale.meta.Cart;
import com.netease.sale.meta.User;
import com.netease.sale.service.serviceImpl.CartServiceImpl;
import com.netease.sale.service.serviceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * 添加购物车,如果购物车中已经存在该产品，则更新购物车记录
     *            如果购物车中没有该商品的购物车记录，则插入购物车记录
     * @param goodsId
     * @param keepNumber
     * @param request
     * @return
     */
    @RequestMapping("/addCart")
    @ResponseBody
    public String addCart(@RequestParam("goodsId") int goodsId, @RequestParam("keepNumber") int keepNumber, HttpServletRequest request){
        int keeperId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
        Cart cart = cartService.selectCart(keeperId,goodsId);
        int num = 0;

        if(cart != null){
            num = cartService.updateCart(keepNumber + cart.getKeepNumber(),cart.getCartId());
        }else {
            num = cartService.addCart(keeperId, goodsId, keepNumber);
        }
       if(num > 0){
           return "success";
       }else{
           return "fail";
       }
    }

    /**
     * 列举购物车中的信息
     * @param request
     * @return
     */
    @RequestMapping("/settleAccount")
    public ModelAndView showCart( HttpServletRequest request){
        int keeperId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
        User user = userService.showCart(keeperId);
        List<Cart> cartItems = null;
        ModelAndView modelAndView = new ModelAndView("settleAccount");
        if(user != null){
            cartItems  = user.getCarts();
            modelAndView.addObject("cartItems", cartItems);
        }
        return  modelAndView;
    }

    /**
     * 删除购物车中的一条记录
     * @param cartId
     * @return
     */
    @RequestMapping("/deleteOneCart")
    @ResponseBody
    public String deleteOneCart(@RequestParam("cartId") int cartId){
        int num = cartService.deleteOneCart(cartId);
        if(num > 0){
            return "success";
        }else{
            return "fail";
        }
    }

}
