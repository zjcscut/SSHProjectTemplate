/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.dispatcher;

import cn.aop.cglibaop.lazyloader.LoaderBean;
import cn.aop.cglibaop.lazyloader.PropertyBean;

/**
 * @author zhangjinci
 * @version 2016/9/9 16:51
 * @function
 */
public class Client {

    public static void main(String[] args){
        DispatcherBean loader = new DispatcherBean();
        System.out.println(loader.getName());
        System.out.println(loader.getValue());
        PropertyBean propertyBean = loader.getPropertyBean(); //访问延迟加载对象

        //只有触发getter方法的时候对象才会加载,再次访问延迟加载对象，每次加载都会回调
        System.out.println(propertyBean.getPropertyName());
        System.out.println(propertyBean.getPropertyValue());

        System.out.println("after.............");

        System.out.println(propertyBean.getPropertyName());
    }
}
