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
 * @version 2016/9/8 19:25
 * @function 普通类使用引介
 */
public class Client2 {

    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(GermenyService.class);
        enhancer.setInterfaces(new Class[]{IHello.class});
        Hello hello = new Hello();
        enhancer.setCallback(new IntroInterceptor(hello));

        GermenyService gs = (GermenyService) enhancer.create();
        gs.sayBye();

        IHello iHello = (IHello) gs;  //把Hello里面的信息织入到GermenyService中
        iHello.sayHello();
    }
}
