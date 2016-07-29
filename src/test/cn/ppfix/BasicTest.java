/*
 * Copyright (c) 2012-2015 zjc@ppfix.cn
 * May you do good and not evil.
 * May you find forgiveness for yourself and forgive others.
 * May you share freely,never taking more than you give.
 * Please do not del these words when you share or copy this file
 */

package cn.pp;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:dispatcher-servlet.xml","classpath:spring-activiti.xml"})
public class BasicTest {
}
