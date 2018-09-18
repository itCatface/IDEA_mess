package cc.catface.springmvc.controller;

import cc.catface.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Controller
public class ProductController {

    @RequestMapping("/addProduct")
    public ModelAndView addProduct(Product product) throws Exception {
        System.out.println("添加了产品...");

        ModelAndView modelAndView = new ModelAndView("product_show");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

}
