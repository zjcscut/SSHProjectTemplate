/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.dispatcher;

import cn.aop.cglibaop.lazyloader.PropertyBean;
import net.sf.cglib.proxy.Dispatcher;

/**
 * @author zhangjinci
 * @version 2016/9/9 16:48
 * @function 每次调用对象的方法都会调此回调
 */
public class ConcreteClassDispatcher implements Dispatcher {

    @Override
    public Object loadObject() throws Exception {
        System.out.println("Dispatcher loadObject()...");
        PropertyBean propertyBean = new PropertyBean();
        propertyBean.setPropertyValue(10000002);
        propertyBean.setPropertyName("dispatcher property bean");
        return propertyBean;
    }
}
