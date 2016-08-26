/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.nutz.dao;

import cn.nutz.entity.Customer;
import org.springframework.stereotype.Repository;

/**
 * @author zhangjinci
 * @version 2016/8/25 9:44
 * @function
 */
@Repository
public class CustomerDao extends BaseDao<Customer> {


    public Customer insert(Customer entity) {
        return super.insert(entity);
    }


    public Customer fastInsert(Customer t) {
        return super.fastInsert(t);
    }

    public int update(Customer customer) {
        return super.update(customer);
    }

    public int delete(Customer customer) {
        return super.delete(customer);
    }

    public int delete(Class<Customer> clazz, Integer id) {
        return super.delete(clazz, id);
    }
}
