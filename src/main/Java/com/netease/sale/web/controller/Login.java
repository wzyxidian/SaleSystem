package com.netease.sale.web.controller;

import com.netease.sale.meta.User;
import com.netease.sale.service.serviceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/2/16.
 */
@Controller
public class Login {

    @Resource
    UserServiceImpl userService;

    /**
     * 验证用户名与密码，将userName，password，flag存放到session中
     * flag用来区分买家和卖家
     *           0：表示买家
     *           1：表示卖家
     * @param userName
     * @param password
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response, Model model)
            throws IOException {
        User user = userService.checkUser(userName, password);
        ModelAndView modelAndView ;
        if(user != null){
            request.getSession().setAttribute("userName",user.getUserName());
            request.getSession().setAttribute("userId",user.getUserId());
            request.getSession().setAttribute("flag", user.getFlag());
            return new ModelAndView("redirect:/");
        }else {
            System.out.println("登录失败");
            return new ModelAndView("redirect:/login?error=passwordError");
        }
    }

    /**
     * 跳转到用户页面
     * @return
     * @throws IOException
     */
    @RequestMapping("/login")
    public  ModelAndView login() throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login");
        return mv;
        //或者执行执行
        //return "login";//返回的页面
    }
}
