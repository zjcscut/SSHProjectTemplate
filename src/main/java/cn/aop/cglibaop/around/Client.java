/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.around;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author zhangjinci
 * @version 2016/9/9 12:06
 * @function
 */
public class Client {

    public static void main(String[] args) throws Exception {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:/cglib"); //代理类字节码输出位置
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteClassWithoutInterface.class); //目标类
        enhancer.setCallback(new ConcreteClassInterceptor()); //拦截器(实现Around增强)
        ConcreteClassWithoutInterface target = (ConcreteClassWithoutInterface) enhancer.create();
        target.getConcreteMethodA("Hello World!");
        target.getConcreteMethodB(10086);

        System.out.println("proxy..." + target.getClass().getName());

    }
}
