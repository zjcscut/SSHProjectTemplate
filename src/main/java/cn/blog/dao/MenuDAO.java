package cn.blog.dao;

import cn.blog.entity.Menu;
import cn.pp.common.dao.BaseDAO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjc
 * @version 2016/7/30 23:14
 * @description
 */
@Repository
public class MenuDAO extends BaseDAO<Menu> {

	@Override
	protected Class<Menu> getEntityClass() {
		return Menu.class;
	}

	public List<Menu> selectAllMainMenus() {
		Query query = getSession().createQuery("from Menu m where m.isDelete = 0 and m.level = 1")
				.setCacheable(true);
		return query.list();
	}

	public List<Menu> selectMenuByPid(Integer pid) {
		Query query = getSession().createQuery("from Menu m where m.isDelete = 0 and m.pid = :pid")
				.setInteger("pid", pid)
				.setCacheable(true);
		return query.list();
	}
}
