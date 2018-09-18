package cc.catface.spring.test;

import cc.catface.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpringByAnnotation {

    @Autowired
    Category c;

    @Test
    public void test() {
        System.out.println("category's default name is-->" + c.getName());
    }

}
