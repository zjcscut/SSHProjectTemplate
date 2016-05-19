package cn.ppfix.common.dao;

import cn.ppfix.entity.Area;
import org.hibernate.Query;
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

    public Area findArea() {
        Query query = getSession().createQuery("from Area a where a.id = :id");
        query.setInteger("id", 2);
        return (Area) query.list().get(0);
    }
}
