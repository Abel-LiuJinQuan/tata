package com.hita.tata.common.filter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面重定向
 * @author abel
 */
@RestController
@RequestMapping(value = "/show")
public class PageController {

    /**
     * 重定向到登录界面
     * @param
     * @return
     */
    @RequestMapping(value = "/getLogin",method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView loginJsp() {
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/static/login.jsp");
        return modelAndView;
    }
}
