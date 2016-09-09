/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.interfacemarker;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhangjinci
 * @version 2016/9/9 16:57
 * @function InterfaceMaker会动态生成一个接口，该接口包含指定类定义的所有方法。
 */
public class Client {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InterfaceMaker im = new InterfaceMaker();
        im.add(ConcreteClassInterfaceMaker.class);
        Class<?> interfaceObject = im.create();
        System.out.println(interfaceObject.isInterface()); //判断是否接口->true
        System.out.println(interfaceObject.getName()); //接口名称

        Method[] methods = interfaceObject.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        //生成接口的代理类
        Object object = Enhancer.create(Object.class, new Class[]{interfaceObject}, new MethodInterceptor() {

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before intercept...");
                System.out.println("args array:" + objects[0]);
                return "intercept";
            }
        });

        //获取接口代理类的指定方法
        Method method = object.getClass().getMethod("getConcreteMethodA", String.class);
        //执行方法，同时会织入增强
        System.out.println(method.invoke(object,new Object[]{"zjcscut"}));
    }
}
