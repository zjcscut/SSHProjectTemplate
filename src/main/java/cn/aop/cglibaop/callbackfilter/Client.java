/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.cglibaop.callbackfilter;

import cn.aop.cglibaop.around.ConcreteClassInterceptor;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author zhangjinci
 * @version 2016/9/9 14:43
 * @function
 */
public class Client {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteClassFilter.class);
        CallbackFilter callbackFilter = new ConcreteCallbackFilter();
        enhancer.setCallbackFilter(callbackFilter); //设置callbackfilter控制callback顺序

        Callback interceptor = new ConcreteClassInterceptor();  //around增强（1）

        Callback noOp = NoOp.INSTANCE;  //(2)什么也不做，直接执行代理方法

        Callback fixedValue = new ConcreteClassFixedValue(); //(3)回调固定值

        //在ConcreteCallbackFilter.accept方法里的callback顺序一致
        //即callbacks[0] 对应 accept方法返回 0 所对应的method
        Callback[] callbacks = new Callback[]{interceptor, noOp, fixedValue};

        enhancer.setCallbacks(callbacks);

        ConcreteClassFilter target = (ConcreteClassFilter) enhancer.create();
        System.out.println("*** NoOp Callback ***");
        target.getConcreteMethodA("hello world1!");
        System.out.println("*** MethodInterceptor Callback ***");
        target.getConcreteMethodB(100);
        System.out.println("*** FixedValue Callback ***");
        int result1 = target.getConcreteMethodFixedValue(10086);
        System.out.println("fixedValue-10086:" + result1);
        int result2 = target.getConcreteMethodFixedValue(10087);
        System.out.println("fixedValue-10087:" + result2);


    }
}
