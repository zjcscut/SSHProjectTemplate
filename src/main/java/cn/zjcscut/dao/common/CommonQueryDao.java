package cn.zjcscut.dao.common;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/6/27 12:28
 */
@SuppressWarnings({"unchecked", "deprecation"})
public abstract class CommonQueryDao<T> {

    private final static int PAGE_SIZE = 20;

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    abstract protected Class<T> getEntityClass();

    protected Long saveLong(T t) {
        return (Long) getSession().save(t);
    }

    protected Integer save(T t) {
        return (Integer) getSession().save(t);
    }

    protected void update(T t) {
        getSession().update(t);
    }

    protected void saveOrUpdate(T t) {
        getSession().saveOrUpdate(t);
    }

    protected T get(Long id) {
        return get(id, false);
    }

    protected T get(Integer id) {
        return get(id, false);
    }


    protected T get(Long id, boolean lock) {
        T entity;
        if (lock) {
            // LockMode.UPGRADE:不管缓存中是否存在对象,总是通过select语句到数据库中加载该对象
            entity = (T) getSession().get(getEntityClass(), id,
                    LockMode.UPGRADE);
        } else {
            entity = (T) getSession().get(getEntityClass(), id);
        }
        return entity;
    }

    protected void del(Integer id) {
        T t = get(id);
        if (t != null) {
            del(t);
        }
    }

    protected void del(Long id) {
        T t = get(id);
        if (t != null) {
            del(t);
        }
    }

    protected void del(T t) {
        getSession().delete(t);
    }


    protected T get(Integer id, boolean lock) {
        T entity;
        if (lock) {
            // LockMode.UPGRADE:不管缓存中是否存在对象,总是通过select语句到数据库中加载该对象
            entity = (T) getSession().get(getEntityClass(), id,
                    LockMode.UPGRADE);
        } else {
            entity = (T) getSession().get(getEntityClass(), id);
        }
        return entity;
    }

    protected List<T> query(Map<String, Object> params, Map<String, String> orderBy) {
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildEqualCriteriaByParams(params, orderBy);
        return criteria.list();
    }

    protected List<T> query(Map<String, Object> params) {
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildEqualCriteriaByParams(params);
        return criteria.list();
    }

    protected List<T> queryByFilter(Map<String, Object> params, Map<String, String> filter) {
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildCriteriaByParams(params, filter);
        return criteria.list();
    }

    protected List<T> queryByFilter(Map<String, Object> params,
                                    Map<String, String> filter, Map<String, String> orderBy) {
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildCriteriaByParams(params, filter, orderBy);
        return criteria.list();
    }

    protected List<T> queryByFilter(Map<String, Object> params, Map<String, String> filter, String orderBy) {
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildCriteriaByParams(params, filter, orderBy);
        return criteria.list();
    }


    protected T queryUnique(Map<String, Object> params) {
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildEqualCriteriaByParams(params);
        return (T) criteria.uniqueResult();
    }

    protected T queryUnique(Map<String, Object> params, Map<String, String> filter) {
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildEqualCriteriaByParams(params, filter);
        return (T) criteria.uniqueResult();
    }


    protected int count(Map<String, Object> params) {
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildEqualCriteriaByParams(params);
        Number count = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
        return count.intValue();
    }

    protected int count(Map<String, Object> params, Map<String, String> filter) {
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildCriteriaByParams(params, filter);
        Number count = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
        return count.intValue();
    }

    protected PageModel<T> queryByPage(Map<String, Object> params, int pageNo, int pageSize) {
        if (pageNo <= 0) pageNo = 1;
        if (pageSize <= 0) pageNo = PAGE_SIZE;
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildEqualCriteriaByParams(params);
        Number count = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
        List<T> list = criteria.list();
        return new PageModel<>(list, count.intValue(), pageNo, pageSize);
    }

    protected PageModel<T> queryByPage(Map<String, Object> params,
                                       Map<String, String> orderBy, int pageNo, int pageSize) {
        if (pageNo <= 0) pageNo = 1;
        if (pageSize <= 0) pageNo = PAGE_SIZE;
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildEqualCriteriaByParams(params, orderBy);
        Number count = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
        List<T> list = criteria.list();
        return new PageModel<>(list, count.intValue(), pageNo, pageSize);
    }

    protected PageModel<T> queryByPage(Map<String, Object> params, String orderBy, int pageNo, int pageSize) {
        if (pageNo <= 0) pageNo = 1;
        if (pageSize <= 0) pageNo = PAGE_SIZE;
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildEqualCriteriaByParamsStringOrder(params, orderBy);
        Number count = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
        List<T> list = criteria.list();
        return new PageModel<>(list, count.intValue(), pageNo, pageSize);
    }

    protected PageModel<T> queryByPageFilter(Map<String, Object> params,
                                             Map<String, String> filter, int pageNo, int pageSize) {
        if (pageNo <= 0) pageNo = 1;
        if (pageSize <= 0) pageNo = PAGE_SIZE;
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildCriteriaByParams(params, filter);
        Number count = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
        List<T> list = criteria.list();
        return new PageModel<>(list, count.intValue(), pageNo, pageSize);
    }

    protected PageModel<T> queryByPageFilter(Map<String, Object> params,
                                             Map<String, String> filter,
                                             Map<String, String> orderBy,
                                             int pageNo, int pageSize) {
        if (pageNo <= 0) pageNo = 1;
        if (pageSize <= 0) pageNo = PAGE_SIZE;
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildCriteriaByParams(params, filter, orderBy);
        Number count = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
        List<T> list = criteria.list();
        return new PageModel<>(list, count.intValue(), pageNo, pageSize);
    }

    protected PageModel<T> queryByPageFilter(Map<String, Object> params,
                                             Map<String, String> filter,
                                             String orderBy,
                                             int pageNo, int pageSize) {
        if (pageNo <= 0) pageNo = 1;
        if (pageSize <= 0) pageNo = PAGE_SIZE;
        Criteria criteria = getSession().createCriteria(this.getEntityClass());
        SqlContextUtils sqlContextUtils = SqlContextUtils.getInstance(criteria);
        sqlContextUtils.buildCriteriaByParams(params, filter, orderBy);
        Number count = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
        List<T> list = criteria.list();
        return new PageModel<>(list, count.intValue(), pageNo, pageSize);
    }

}
