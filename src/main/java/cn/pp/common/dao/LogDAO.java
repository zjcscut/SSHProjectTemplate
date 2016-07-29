package cn.pp.common.dao;

import cn.pp.entity.Log;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zjc
 * @version 2016/6/2 20:48
 */
@Repository
public class LogDAO extends BaseDAO<Log> {

	@Override
	protected Class<Log> getEntityClass() {
		return Log.class;
	}

	public Long selectCount() {
		Query query = getSession().createQuery("select count(log.key) from Log log")
				.setCacheable(true);
		return (Long) query.uniqueResult();
	}
}
