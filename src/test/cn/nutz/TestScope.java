/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.nutz;

import cn.nutz.dao.CustomerDao;
import cn.nutz.entity.Customer;
import cn.ppfix.BasicTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author zhangjinci
 * @version 2016/8/25 9:55
 * @function
 */
public class TestScope  extends BasicTest{

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void Test1(){
        Customer c = new Customer();
        c.setName("zjc");
        c.setBirth(new Date());
        customerDao.fastInsert(c);
    }
}
