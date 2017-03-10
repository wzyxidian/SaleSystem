package com.netease.sale.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by Administrator on 2017/3/6.
 */
@Controller
public class LoginShow {

    @RequestMapping("/login")
    public  ModelAndView login() throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
        //或者执行执行
        //return "login";//返回的页面
    }
}
