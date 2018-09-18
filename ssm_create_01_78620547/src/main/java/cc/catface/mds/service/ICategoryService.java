package cc.catface.mds.service;

import cc.catface.mds.model.Category;
import cc.catface.mds.model.Page;

import java.util.List;

public interface ICategoryService {

    /* 1. */
    List<Category> list();


    /* 2. */
    List<Category> listByPage(Page page);

    int total();


    /* 3. */
    List<Category> listByPager();


    /* 4. */
    void add(Category category);

    void update(Category category);

    void delete(Category category);

    Category get(int id);
}