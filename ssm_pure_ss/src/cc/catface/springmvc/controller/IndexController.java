package cc.catface.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
//public class IndexController implements Controller {
@Controller
public class IndexController {




    //    @Override
    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("进入" + getClass().getName() + "...");

        ModelAndView modelAndView = new ModelAndView("index.jsp");
        modelAndView.addObject("message", "你好Hello Spring MVC!");

        return modelAndView;
    }


    /* 105 - 客户端跳转 */
    @RequestMapping("/jump")
    public ModelAndView jump() {

        /* redirect:/hi表示客户端跳转 */
        ModelAndView modelAndView = new ModelAndView("redirect:/hi");
        modelAndView.addObject("message", "hi222(jump)~~");
        modelAndView.addObject("date", new Date().toLocaleString());
        return modelAndView;
    }


    /* 106 - session */
    @RequestMapping("check")
    public ModelAndView check(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (null == count) count = 0;
        count++;
        session.setAttribute("count", count);
        ModelAndView modelAndView = new ModelAndView("check");
        return modelAndView;
    }
}
