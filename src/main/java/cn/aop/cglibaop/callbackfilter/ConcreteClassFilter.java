/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.callbackfilter;

/**
 * @author zhangjinci
 * @version 2016/9/9 14:42
 * @function
 */
public class ConcreteClassFilter {

    public String getConcreteMethodA(String str) {
        System.out.println("ConcreteMethod A ... " + str);
        return str;
    }

    public Integer getConcreteMethodB(int n) {
        System.out.println("ConcreteMethod B ... " + n);
        return n + 10;
    }

    public Integer getConcreteMethodFixedValue(int n) {
        System.out.println("getConcreteMethodFixedValue..." + n);
        return n + 10;
    }
}
