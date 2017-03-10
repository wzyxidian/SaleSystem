package com.netease.sale.web.controller;

import com.netease.sale.meta.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/2/17.
 */
@Controller
public class Logout {
    @RequestMapping("/logout")
    public ModelAndView loginCheck(HttpServletRequest request)
            throws IOException {
        request.getSession().setAttribute("userName",null);
        request.getSession().setAttribute("userId",null);
        System.out.println("退出成功");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
