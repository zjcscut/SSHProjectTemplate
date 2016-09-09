/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.dispatcher;

import cn.aop.cglibaop.lazyloader.PropertyBean;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author zhangjinci
 * @version 2016/9/9 16:46
 * @function
 */
public class DispatcherBean {

    private String name;
    private String value;
    private PropertyBean propertyBean;

    public DispatcherBean() {
        this.name = "dispatcher bean";
        this.value = "100878";
        propertyBean = createDispatcherBean();
    }

    protected PropertyBean createDispatcherBean(){
        return (PropertyBean) Enhancer.create(PropertyBean.class,new ConcreteClassDispatcher());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PropertyBean getPropertyBean() {
        return propertyBean;
    }

    public void setPropertyBean(PropertyBean propertyBean) {
        this.propertyBean = propertyBean;
    }
}
