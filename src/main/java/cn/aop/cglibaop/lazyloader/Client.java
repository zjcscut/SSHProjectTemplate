/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.lazyloader;

/**
 * @author zhangjinci
 * @version 2016/9/9 16:35
 * @function 对象懒加载
 */
public class Client {

    public static void main(String[] args) {
        LoaderBean loader = new LoaderBean();
        System.out.println(loader.getLoaderName());
        System.out.println(loader.getLoaderValue());
        PropertyBean propertyBean = loader.getPropertyBean(); //访问延迟加载对象

        //只有触发getter方法的时候对象才会加载
        System.out.println(propertyBean.getPropertyName());
        System.out.println(propertyBean.getPropertyValue());

        System.out.println("after.............");
        //再次访问延迟加载对象，不会再执行回调
        System.out.println(propertyBean.getPropertyName());
    }
}
