/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.lazyloader;

import net.sf.cglib.proxy.LazyLoader;

/**
 * @author zhangjinci
 * @version 2016/9/9 16:29
 * @function
 */
public class ConcreteClassLazyLoader implements LazyLoader {

    @Override
    public Object loadObject() throws Exception {
        System.out.println("Lazyloader loadObject()...");
        PropertyBean bean = new PropertyBean();
        bean.setPropertyName("lazy-load object propertyName!");
        bean.setPropertyValue(10086);
        return bean;
    }
}
