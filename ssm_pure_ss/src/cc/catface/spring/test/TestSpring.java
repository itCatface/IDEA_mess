package cc.catface.spring.test;

import cc.catface.spring.service.CommonService;
import cc.catface.pojo.Category;
import cc.catface.pojo.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class TestSpring {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});


        /* 通过IOC/DI从Spring获取对象(配置文件中) */
        Category c = (Category) context.getBean("c");
        System.out.println(c.getName() + "\r\n");


        /* 获取注入对象的属性 */
        Product p = (Product) context.getBean("p");
        System.out.println("p's name/category is: " + p.getName() + "/" + p.getCategory().getName() + "\r\n");


        /* AOP */
        CommonService service = (CommonService) context.getBean("s");
        service.doService();

    }

}
