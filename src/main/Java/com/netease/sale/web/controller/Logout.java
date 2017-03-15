package com.netease.sale.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2017/2/17.
 */
@Controller
public class Logout {

    /**
     * 退出
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/logout")
    public ModelAndView loginCheck(HttpServletRequest request)
            throws IOException {
        request.getSession().setAttribute("userName",null);
        request.getSession().setAttribute("userId",null);
        request.getSession().setAttribute("flag",null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
