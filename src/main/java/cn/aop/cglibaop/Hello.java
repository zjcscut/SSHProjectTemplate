/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop;

/**
 * @author zhangjinci
 * @version 2016/9/8 19:19
 * @function 单独实现IHello接口的另一个类
 */
public class Hello implements IHello {

    @Override
    public void sayHello() {
        System.out.println("say hello from helloImpl class");
    }
}
