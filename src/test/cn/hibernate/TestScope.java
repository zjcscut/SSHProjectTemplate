/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.hibernate;

import cn.pp.entity.Area;
import cn.ppfix.BasicTest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/8/25 16:26
 * @function
 */
public class TestScope extends BasicTest {


    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void Test1() {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("SELECT {T.*} FROM (SELECT * FROM area a WHERE a.name = '福州' UNION SELECT * FROM area a WHERE a.id = 1) T")
                .addEntity("T", Area.class);
        List<Area> list = query.list();
        System.out.println(list);
        session.close();
    }


    //如果想使用hibernate使用jdbc的还原点，操作如下
    @Test
    public void Test2() {
        Session session = sessionFactory.openSession();

        Work work = new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = null;
                Savepoint sp = null;
                try {
                    connection.setAutoCommit(false); //取消自动提交

                    String sql1 = "UPDATE area a SET a.name = '福州update' WHERE a.id = 1";
                    preparedStatement = connection.prepareStatement(sql1);
                    preparedStatement.executeUpdate();


                    sp = connection.setSavepoint(); //设置还原点，回滚后只提交sql1


                    String sql2 = "UPDATE area a SET a.name = '太原update' WHERE a.id = 2";
                    preparedStatement = connection.prepareStatement(sql2);
                    preparedStatement.executeUpdate();

                    //模拟抛出异常
                    int x = 1 / 0;
                    String sql3 = "UPDATE area a SET a.name = '成都update' WHERE a.id = 3";
                    preparedStatement = connection.prepareStatement(sql3);
                    preparedStatement.executeUpdate();

                    connection.commit();  //提交事务

                    System.out.println("提交事务成功");
                } catch (Exception e) {
                    try {
                        System.out.println("回滚事务到保存点");
                        connection.rollback(sp);  //回滚到事务还原点

                        connection.commit();  //再次提交还原点

                        connection.releaseSavepoint(sp); //释放还原点
                    } catch (Exception e1) {
                        e.printStackTrace();
                    }
                } finally {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                }
            }
        };
        session.doWork(work);

        session.close();
    }
}
