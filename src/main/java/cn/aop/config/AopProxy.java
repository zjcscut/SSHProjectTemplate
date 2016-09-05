/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.config;

/**
 * @author zhangjinci
 * @version 2016/9/2 15:10
 * @function
 */
public interface AopProxy {

    Object getProxy();  //获取线程上下文的ClassLoader

    Object getProxy(ClassLoader classLoader);
}
