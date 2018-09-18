package cc.catface.mds.dao;

import cc.catface.mds.model.Category;
import cc.catface.mds.model.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ICategoryDaoTest {

    @Autowired
    private ICategoryDao categoryDao;


      @Test
    public void testAdd() {
        for (int i = 0; i < 100; i++) {
            Category category = new Category();
            category.setName("new Category");
            categoryDao.add(category);
        }

    }

    @Test
    public void testTotal() {
        int total = categoryDao.total();
        System.out.println(total);
    }

    @Test
    public void testList() {
        Page p = new Page();
        p.setStart(2);
        p.setCount(3);
        List<Category> cs=categoryDao.listByPage(p);
        for (Category c : cs) {
            System.out.println(c.getName());
        }
    }

}
