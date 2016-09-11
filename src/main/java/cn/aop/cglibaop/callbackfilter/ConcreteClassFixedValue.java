/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.callbackfilter;

import net.sf.cglib.proxy.FixedValue;

/**
 * @author zhangjinci
 * @version 2016/9/9 14:46
 * @function 回调固定值
 */
public class ConcreteClassFixedValue implements FixedValue {

    @Override
    public Object loadObject() throws Exception {
        System.out.println("ConcreteClassFixedValue loadObject ...");

        return 9999;
    }
}
