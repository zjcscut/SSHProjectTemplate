package cn.pp.common.dao;

import cn.pp.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjc
 * @version 2016/5/20 2:15
 */
@Repository
public class CategoryDAO extends BaseDAO<Category> {

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    public Category findCategoryByName(String name) {
        List results = getSession().createQuery("from Category as c where c.name='" + name + "'").list();
        return (Category) results.iterator().next();
    }
}
