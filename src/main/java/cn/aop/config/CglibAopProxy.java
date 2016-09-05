/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.config;

import java.io.Serializable;

/**
 * @author zhangjinci
 * @version 2016/9/2 15:13
 * @function
 */
public class CglibAopProxy implements AopProxy,Serializable{

    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }
}
