package cn.zjcscut.dao.common;

import cn.ppfix.entity.Area;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/6/24 16:00
 */
@Repository
public class SqlDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Area> selectAreaByCondition(Map<String, String> params, Map<String, String> filter) {
        Criteria criteria = getSession().createCriteria(Area.class);
        SqlContextUtils.buildCriteriaByParams(params, filter, criteria);
        return criteria.list();
    }
}
