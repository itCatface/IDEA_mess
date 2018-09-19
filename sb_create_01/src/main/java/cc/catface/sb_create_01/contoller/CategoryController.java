package cc.catface.sb_create_01.contoller;

import cc.catface.sb_create_01.mds.dao.ICategoryDAO;
import cc.catface.sb_create_01.mds.mapper.Category2Mapper;
import cc.catface.sb_create_01.mds.pojo.Category;
import cc.catface.sb_create_01.mds.pojo.Category2;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Controller
public class CategoryController {


    /** 1.使用JPA查看数据 */
    @Autowired
    private ICategoryDAO categoryDAO;

    @RequestMapping("/listCategoryJ1")
    public String listCategoryJ1(Model model) throws Exception {
        List<Category> categories = categoryDAO.findAll();

        model.addAttribute("cs", categories);
        return "listCategoryJ1";
    }


    /** 2.使用mybatis注解方式查看数据 */
    @Autowired
    private Category2Mapper category2Mapper;

    @RequestMapping("listCategoryM1")
    public String listCategoryM1(Model model) throws Exception {
        List<Category2> category2s = category2Mapper.findAll();
        model.addAttribute("cs", category2s);
        return "listCategoryM1";
    }


    /** 3.使用JPA进行CRUD及分页 */
    @RequestMapping("/addCategoryJ2")
    public String addCategoryJ2(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:listCategoryJ2";
    }

    @RequestMapping("/deleteCategoryJ2")
    public String deleteCategoryJ2(Category c) throws Exception {
        categoryDAO.delete(c);
        return "redirect:listCategoryJ2";
    }

    @RequestMapping("/updateCategoryJ2")
    public String updateCategoryJ2(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:listCategoryJ2";
    }

    @RequestMapping("/editCategoryJ2")
    public String editCategoryJ2(int id, Model m) throws Exception {
        Category c = categoryDAO.getOne(id);
        m.addAttribute("c", c);
        return "editCategoryJ2";
    }

    @RequestMapping("/listCategoryJ2")
    public String listCategoryJ2(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page = categoryDAO.findAll(pageable);
        m.addAttribute("page", page);
        return "listCategoryJ2";
    }


    /** 4.使用mybatis进行CRUD及分页 */
    @RequestMapping("/addCategoryM2")
    public String listCategoryM2(Category2 c) throws Exception {
        category2Mapper.save(c);
        return "redirect:listCategoryM2";
    }

    @RequestMapping("/deleteCategoryM2")
    public String deleteCategoryM2(Category2 c) throws Exception {
        category2Mapper.delete(c.getId());
        return "redirect:listCategoryM2";
    }

    @RequestMapping("/updateCategoryM2")
    public String updateCategoryM2(Category2 c) throws Exception {
        category2Mapper.update(c);
        return "redirect:listCategoryM2";
    }

    @RequestMapping("/editCategoryM2")
    public String listCategoryM2(int id, Model m) throws Exception {
        Category2 c = category2Mapper.get(id);
        m.addAttribute("c", c);
        return "editCategoryM2";
    }

    @RequestMapping("/listCategoryM2")
    public String listCategoryM2(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "id desc");
        List<Category2> cs = category2Mapper.findAll();
        PageInfo<Category2> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        return "listCategoryM2";
    }

}
