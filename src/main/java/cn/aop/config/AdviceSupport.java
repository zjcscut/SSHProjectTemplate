/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.config;

import cn.aop.config.advice.Advice;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/9/2 16:49
 * @function
 */
public class AdviceSupport {

    /**
     * 被代理的对象
     */
    private Object target;

    /**
     * 被代理的对象类型
     */
    private Class<?> targetClass;

    /**
     *
     */
    private List<Advice> advices;

    private List<MethodInterceptor> methodInterceptors;

    private Class<?>[] interfaces;

    private ClassLoader classLoader;






}
