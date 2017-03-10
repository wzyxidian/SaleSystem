package com.netease.sale.web.controller;

import com.netease.sale.meta.Buy;
import com.netease.sale.meta.Product;
import com.netease.sale.meta.User;
import com.netease.sale.service.serviceImpl.UserServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/16.
 */
@Controller
public class Login {

    @Resource
    UserServiceImpl userService;

    @RequestMapping("/loginCheck")
    @ResponseBody
    public ModelAndView loginCheck(@RequestParam("userName") String userName, @RequestParam("userPassword") String password, HttpServletRequest request, HttpServletResponse response, Model model)
            throws IOException {
        User user = userService.checkUser(userName, password);
        System.out.println(password);
        if(user != null){
            request.getSession().setAttribute("userName",user.getUserName());
            request.getSession().setAttribute("userId",user.getUserId());
            request.getSession().setAttribute("flag", user.getFlag());
            System.out.println("flag: " + user.getFlag());
            System.out.println("用户昵称 " + user.getUserId());
            System.out.println("登陆成功");
//            ModelAndView modelAndView = new ModelAndView("redirect:/index");
            ModelAndView modelAndView = new ModelAndView("redirect:/index");

            return modelAndView;
        }else {
            System.out.println("登录失败");
            ModelAndView modelAndView = new ModelAndView("redirect:/login?error=passwordError");
            return modelAndView;
        }
    }
}
