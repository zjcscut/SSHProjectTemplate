/*
 * Copyright (c) 2012-2015 zjc@ppfix.cn
 * May you do good and not evil.
 * May you find forgiveness for yourself and forgive others.
 * May you share freely,never taking more than you give.
 * Please do not del these words when you share or copy this file
 */

package cn.ppfix;

import cn.ppfix.entity.Area;
import cn.ppfix.service.AreaService;
import cn.ppfix.utils.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @version 2016/1/7-16:26
 */
public class TestScope extends BasicTest {

    @Autowired
    private AreaService areaService;
    @Test
    public void Test1() {
        Area  a = areaService.findArea();
        System.out.println("id--" + a.getId());
        System.out.println("name--" + a.getName());
        System.out.println("parant--" + a.getParent());
        System.out.println("nodes--" + a.getNodes());
        System.out.println("json--" + JsonUtil.toJson(a));
    }
}
