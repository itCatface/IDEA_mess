package cc.catface.sb_create_01_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("name", "thymeleaf");
        return "hello";
    }

}
