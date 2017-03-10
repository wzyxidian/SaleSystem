package com.netease.sale.web.controller;

import com.netease.sale.meta.Buy;
import com.netease.sale.meta.Cart;
import com.netease.sale.meta.Product;
import com.netease.sale.meta.User;
import com.netease.sale.service.serviceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/2/18.
 */
@Controller
public class BuyedProductList {
    @Resource
    private UserServiceImpl userService;

    /**
     * 列举用户所有购买的商品
     * @param request
     * @return
     */
    @RequestMapping("show/buy")
    public String buyedProductList(HttpServletRequest request){
        int userId = Integer.valueOf(request.getSession().getAttribute("userId").toString());
//        int userId=3;
        User user = userService.buyedProductList(userId);
       /* List<Buy> buys = user.getBuys();
        List<Cart> carts = user.getCarts();
        for(int i=0;i<buys.size();i++){
            System.out.println("--------");
            System.out.println(buys.get(i).getBuyerId());
            System.out.println(buys.get(i).getBuyId());
            System.out.println(buys.get(i).getBuyTime());
            System.out.println(buys.get(i).getGoodsId());
            System.out.println(buys.get(i).getNumber());
            System.out.println(buys.get(i).getProduct().getDetail());
            System.out.println(buys.get(i).getProduct().getAbstracts());
            System.out.println();

        }*/

        return "index";
    }
}
