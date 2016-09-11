/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.callbackfilter;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author zhangjinci
 * @version 2016/9/9 14:42
 * @function
 */
public class ConcreteCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        //callback顺序
        if ("getConcreteMethodB".equals(method.getName())) {
            return 0;//Callback callbacks[0]
        } else if ("getConcreteMethodA".equals(method.getName())) {
            return 1;//Callback callbacks[1]
        } else if ("getConcreteMethodFixedValue".equals(method.getName())) {
            return 2;//Callback callbacks[2]
        }
        return 1;
    }
}
