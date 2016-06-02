package cn.ppfix.common.dao;

import cn.ppfix.dto.AreaDTO;
import cn.ppfix.entity.Area;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
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

    public AreaDTO getByNativeSQLAndTransferBean(Integer id) {
        Query query = getSession().createSQLQuery("SELECT a.id AS id,a.name AS name FROM area a WHERE a.id = :id")
                .setInteger("id", id)
                .setResultTransformer(Transformers.aliasToBean(AreaDTO.class));
        return (AreaDTO) query.uniqueResult();
    }


    //原生SQL联合查询，addEntity必須為第一個參數
    public Area getByNativeSQL(Integer id) {
        Query query = getSession().createSQLQuery("SELECT {a.*} FROM area a,categories c WHERE a.id = c.id AND c.id = :id")
                .addEntity("a", Area.class)
                .setInteger("id", id);
        return (Area) query.uniqueResult();
    }

    //实体内某个参数为一个实体的查询
    public Area selectByHql(Integer id) {
        Query query = getSession().createQuery("from Area a where a.id = :id")
                .setInteger("id", id);
        return (Area) query.uniqueResult();
    }

    //HQL联合查询
    public AreaDTO selectByHqlTransDTO(Integer id) {
        Query query = getSession().createQuery("SELECT a.id as id,a.name as name FROM Area a,District d where d.id = :id and d.areaId = a.id")
                .setInteger("id", id)
                .setResultTransformer(Transformers.aliasToBean(AreaDTO.class));
        return (AreaDTO) query.uniqueResult();
    }

}
