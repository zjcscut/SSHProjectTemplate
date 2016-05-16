/*
 * Copyright (c) 2012-2015 zjc@ppfix.cn
 * May you do good and not evil.
 * May you find forgiveness for yourself and forgive others.
 * May you share freely,never taking more than you give.
 * Please do not del these words when you share or copy this file
 */

package cn.ppfix;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @version 2016/1/7-16:26
 */
public class TestScope extends BasicTest {

    @Test
    public void Test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[]{
                        "classpath:spring-config.xml"
                }
        );

        ac.getBean("bean");
    }
}
