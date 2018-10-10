package cc.catface.sb_create_thymeleaf_01.controller.for_h5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Controller
@RequestMapping("/h5")
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "h5_index";
    }

}
