package cc.catface.sb_create_01.contoller;

import cc.catface.sb_create_01.mds.dao.ICategoryDAO;
import cc.catface.sb_create_01.mds.mapper.Category2Mapper;
import cc.catface.sb_create_01.mds.pojo.Category;
import cc.catface.sb_create_01.mds.pojo.Category2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Controller
public class CategoryController {


    /** 使用JPA查看数据 */
    @Autowired
    private ICategoryDAO categoryDAO;

    @RequestMapping("/listCategory")
    public String listCategory(Model model) throws Exception {
        List<Category> categories = categoryDAO.findAll();

        model.addAttribute("cs", categories);
        return "listCategory";
    }


    /** 使用mybatis注解方式查看数据 */
    @Autowired
    private Category2Mapper category2Mapper;

    @RequestMapping("listCategory2")
    public String listCategory2(Model model) throws Exception {
        List<Category2> category2s = category2Mapper.findAll();
        model.addAttribute("cs", category2s);
        return "listCategory2";
    }

}
