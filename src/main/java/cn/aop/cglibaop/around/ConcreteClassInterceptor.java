/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.around;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangjinci
 * @version 2016/9/9 12:03
 * @function 模拟around增强
 */
public class ConcreteClassInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("Before..." + method);
        Object result =  methodProxy.invokeSuper(o,objects);
        System.out.println("After..." + method);
        return result;
    }
}
