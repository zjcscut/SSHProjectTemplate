/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author zhangjinci
 * @version 2016/9/8 19:20
 * @function 接口使用引介
 */
public class Client {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(GermenyService.class);
        enhancer.setInterfaces(new Class[]{IHello.class});
        enhancer.setCallback(new IntroInterceptor());

        GermenyService gs = (GermenyService) enhancer.create();
        gs.sayBye();

        IHello iHello = (IHello) gs; //GermenyService实现了IHello
        iHello.sayHello();
    }
}
