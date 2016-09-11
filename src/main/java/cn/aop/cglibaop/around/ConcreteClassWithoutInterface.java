/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.around;

/**
 * @author zhangjinci
 * @version 2016/9/9 12:00
 * @function 没有实现接口的普通类
 */
public class ConcreteClassWithoutInterface {

    public String getConcreteMethodA(String str){
        System.out.println("ConcreteMethodA..." + str);
        return str;
    }

    public Integer getConcreteMethodB(Integer n){
        System.out.println("ConcreteMethodB..." + n);
        return n + 10;
    }
}
