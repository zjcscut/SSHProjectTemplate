/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangjinci
 * @version 2016/9/8 19:13
 * @function 拦截器, 实现织入功能的核心
 */
public class IntroInterceptor implements MethodInterceptor, IHello {

    //实现了IHello接口的对象
    private Object delegate;

    public IntroInterceptor() {
        this.delegate = this;
    }

    public IntroInterceptor(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public void sayHello() {
        System.out.println("say hello from delegate!");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Class<?> clazz = method.getDeclaringClass();
        if (clazz.isAssignableFrom(IHello.class)) { // 如果实现了IHello增强接口，则调用实现类delegate的方法
            return method.invoke(delegate, objects);
        }
        return methodProxy.invokeSuper(o, objects);
    }
}
