/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.lazyloader;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author zhangjinci
 * @version 2016/9/9 15:07
 * @function
 */
public class LoaderBean {

    private String loaderName;
    private int loaderValue;

    private PropertyBean propertyBean;

    public LoaderBean() {
        this.loaderName = "loaderBean init";
        this.loaderValue = 1000899;
        this.propertyBean = LazyCreatePropertyBean();
    }

    protected PropertyBean LazyCreatePropertyBean(){
        return (PropertyBean) Enhancer.create(PropertyBean.class,new ConcreteClassLazyLoader());
    }

    public String getLoaderName() {
        return loaderName;
    }

    public void setLoaderName(String loaderName) {
        this.loaderName = loaderName;
    }

    public int getLoaderValue() {
        return loaderValue;
    }

    public void setLoaderValue(int loaderValue) {
        this.loaderValue = loaderValue;
    }

    public PropertyBean getPropertyBean() {
        return propertyBean;
    }

    public void setPropertyBean(PropertyBean propertyBean) {
        this.propertyBean = propertyBean;
    }
}
