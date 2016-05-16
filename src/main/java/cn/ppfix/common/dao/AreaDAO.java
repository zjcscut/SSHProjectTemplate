package cn.ppfix.common.dao;

import cn.ppfix.common.entity.Area;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjc
 * @version 2016/5/16 22:08
 */
@Repository
public class AreaDAO extends BaseDAO<Area> {

    @Override
    protected Class<Area> getEntityClass() {
        return Area.class;
    }

    public List<Area> findAreaByName(String name) {
//        Criteria criteria = getSession().createCriteria(Area.class);
//        criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
//        return criteria.list();
        Query query = getSession().createQuery("from Area a where a.name = :name");
        query.setString("name", name);
        return query.list();
    }
}
