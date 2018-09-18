package cc.catface.mds.service.imp;

import cc.catface.mds.dao.ICategoryDao;
import cc.catface.mds.model.Category;
import cc.catface.mds.model.Page;
import cc.catface.mds.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryDao categoryDao;

    /* 1. */
    @Override
    public List<Category> list() {
        return categoryDao.list();
    }


    /* 2. */
    @Override
    public List<Category> listByPage(Page page) {
        return categoryDao.listByPage(page);
    }

    @Override
    public int total() {
        return categoryDao.total();
    }


    /* 3. */
    @Override
    public List<Category> listByPager() {
        return categoryDao.listByPager();
    }


    /* 4. */
    @Override
    public void add(Category category) {
        categoryDao.add(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category.getId());
    }

    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }
}