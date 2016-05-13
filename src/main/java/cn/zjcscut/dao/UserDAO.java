package cn.zjcscut.dao;

import cn.zjcscut.dao.base.BaseDAO;
import cn.zjcscut.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjc
 * @version 2016/5/13 1:42
 */
@Repository
public class UserDAO extends BaseDAO<User> {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    public List<User> selectByAge(int age) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("select u.* from user u where u.age > :age");
        Query query = getSession().createSQLQuery(sqlBuilder.toString())
                .addEntity(User.class);
        query.setInteger("age", age);
        return query.list();
    }
}
