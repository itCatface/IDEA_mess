package cc.catface.mds.dao;

import cc.catface.mds.model.Category;
import cc.catface.mds.model.Page;

import java.util.List;

public interface ICategoryDao {

    /* 1. */
    List<Category> list();


    /* 2. */
    List<Category> listByPage(Page page);

    int total();

    /* 3. */
    List<Category> listByPager();


    /* 4. */
    int add(Category category);

    void delete(int id);

    Category get(int id);

    int update(Category category);
}