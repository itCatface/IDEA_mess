package cc.catface.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class HiController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView modelAndView = new ModelAndView("hi");
        modelAndView.addObject("message", "hi~~");
        modelAndView.addObject("date", new Date().toLocaleString());

        return modelAndView;
    }
}
