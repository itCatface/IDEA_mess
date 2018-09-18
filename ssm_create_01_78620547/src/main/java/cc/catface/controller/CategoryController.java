package cc.catface.controller;

import cc.catface.mds.model.Category;
import cc.catface.mds.model.Page;
import cc.catface.mds.service.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(produces = "application/json; charset=utf-8")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @RequestMapping("/listCategory")
    public ModelAndView listCategory() {
        ModelAndView mav = new ModelAndView();
        List<Category> cs = categoryService.list();

        // 放入转发参数
        mav.addObject("cs", cs);
        // 放入jsp路径
        mav.setViewName("listCategory");
        return mav;
    }


    @RequestMapping("/listCategoryByPage")
    public ModelAndView listCategoryByPage(Page page) {

        ModelAndView mav = new ModelAndView();
        List<Category> categories = categoryService.listByPage(page);
        int total = categoryService.total();

        page.caculateLast(total);

        // 放入转发参数
        mav.addObject("cs", categories);
        // 放入jsp路径
        mav.setViewName("listCategoryByPage");
        return mav;
    }


    @RequestMapping("/listCategoryByPager")
    public ModelAndView listCategoryByPager(Page page) {
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(), 5);
        List<Category> categories = categoryService.listByPager();
        int total = (int) new PageInfo<>(categories).getTotal();

        page.caculateLast(total);

        // 放入转发参数
        mav.addObject("cs", categories);
        // 放入jsp路径
        mav.setViewName("listCategoryByPage");
        return mav;
    }


    /** CRUD */
    @RequestMapping("/addCategory")
    public ModelAndView addCategory(Category category) {
        categoryService.add(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }

    @RequestMapping("/deleteCategory")
    public ModelAndView deleteCategory(Category category) {
        categoryService.delete(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }

    @RequestMapping("/editCategory")
    public ModelAndView editCategory(Category category) {
        Category c = categoryService.get(category.getId());
        ModelAndView mav = new ModelAndView("editCategory");
        mav.addObject("c", c);
        return mav;
    }

    @RequestMapping("/updateCategory")
    public ModelAndView updateCategory(Category category) {
        categoryService.update(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }


    /** CRUD with RESTful风格 */
    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public ModelAndView addCategory2(Category category) {
        System.out.println("category.getName():" + category.getName());
        categoryService.add(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategoryByPageWithRESTful");
        return mav;
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteCategory2(Category category) {
        categoryService.delete(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategoryByPageWithRESTful");
        return mav;
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    public ModelAndView editCategory2(Category category) {
        Category c = categoryService.get(category.getId());
        ModelAndView mav = new ModelAndView("editCategoryWithRESTful");
        mav.addObject("c", c);
        return mav;
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.PUT)
    public ModelAndView updateCategory2(Category category) {
        categoryService.update(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategoryByPageWithRESTful");
        return mav;
    }

}