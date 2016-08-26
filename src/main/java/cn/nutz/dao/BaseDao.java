/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.nutz.dao;

import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author zhangjinci
 * @version 2016/8/25 9:46
 * @function
 */
public abstract class BaseDao<T> {

    @Autowired
    @Qualifier("nutDao")
    private NutDao nutDao;

    public <T> T insert(T entity) {
        return nutDao.insert(entity);
    }

    public <T> T fastInsert(T t) {
        return nutDao.fastInsert(t);
    }

    public int update(T t) {
        return nutDao.update(t);
    }

    public int delete(T t) {
        return nutDao.delete(t);
    }

    public int delete(Class<T> clazz, Integer id) {
        return nutDao.delete(clazz, id);
    }
}
