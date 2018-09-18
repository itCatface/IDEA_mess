package cc.catface.mybatis;

import cc.catface.pojo.Category;
import cc.catface.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class TestMybatis {

    private static SqlSession mSqlSession;

    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mSqlSession = sqlSession;

        List<Category> list = sqlSession.selectList("listCategory");
        for (Category category : list) {
            System.out.println(category.getName());
        }

        //        insert();
        //        delete();
        //        select();
        //        update();

        System.out.println();
        //        selectByName();
        //        selectByIdAndName();


        System.out.println();
//        listCategory2();


        System.out.println();
        listProduct();

        mSqlSession.commit();
        mSqlSession.close();
    }


    /** CRUD */
    private static void insert() {
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setName("新增类目" + i);
            mSqlSession.insert("addCategory", c);
        }
    }

    private static void delete() {
        Category c = new Category();
        c.setId(7);
        mSqlSession.delete("deleteCategory", c);
    }

    private static Category select() {
        Category selectCategory = (Category) mSqlSession.selectOne("selectCategory", 6);
        System.out.println("已选的类目为：" + selectCategory.getName() + "||" + selectCategory.getId());
        return selectCategory;
    }

    private static void update() {
        Category select = select();
        select.setName("修改后的类目名");
        mSqlSession.update("updateCategory", select);
    }


    /** 更多查询 */
    /* 模糊查询 */
    private static void selectByName() {
        List<Category> list = mSqlSession.selectList("listCategoryByName", "cat");
        for (Category category : list) {
            System.out.println(category.getName());
        }
    }


    /* 多条件查询 */
    private static void selectByIdAndName() {
        Map<String, Object> params = new HashMap<>();
        params.put("id", 1);
        params.put("name", "cat");

        List<Category> list = mSqlSession.selectList("listCategoryByIdAndName", params);
        for (Category category : list) {
            System.out.println(category.getName());
        }
    }


    /** 一对多 */
    private static void listCategory2() {
        List<Category> cs = mSqlSession.selectList("listCategory2");
        for (Category c : cs) {
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t" + p);
            }
        }
    }


    /** 多对一 */
    private static void listProduct() {
        List<Product> ps = mSqlSession.selectList("listProduct");
        for (Product p : ps) {
            System.out.println(p+" 对应的分类是 \t "+ p.getCategory());
        }
    }

}
