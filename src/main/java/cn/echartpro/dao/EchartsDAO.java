package cn.echartpro.dao;

import cn.echartpro.vo.EchartsDataResult;
import cn.pp.common.dao.BaseDAO;
import cn.pp.entity.OrderInfo;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/7/20 20:36
 * @function
 */
@Repository
public class EchartsDAO extends BaseDAO<OrderInfo> {


    @Override
    protected Class<OrderInfo> getEntityClass() {
        return OrderInfo.class;
    }

    public List<EchartsDataResult> selectAll() {
        Query query = getSession().createQuery("select a.name as name,count(o.id) as num from OrderInfo o,Area a where a.id = o.provinceId and o.isDelete = 0 group by a.name order by count(o.id) desc ");
        query.setResultTransformer(Transformers.aliasToBean(EchartsDataResult.class));
        return query.list();
    }

}
