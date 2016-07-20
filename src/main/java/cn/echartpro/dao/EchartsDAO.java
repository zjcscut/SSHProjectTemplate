package cn.echartpro.dao;

import cn.echartpro.vo.EchartsDataResult;
import cn.ppfix.common.dao.BaseDAO;
import cn.ppfix.entity.OrderInfo;
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
        Query query = getSession().createQuery("select a.name,count(o.id) from OrderInfo o,Area a where a.id = o.provinceId and o.isDelete = 0 group by a.name");
        query.setResultTransformer(Transformers.aliasToBean(EchartsDataResult.class));
        return query.list();
    }
}
