package cn.pp.cglib.advice;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangjinci
 * @version 2016/6/17 8:53
 */
public class AroundAdvice implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行目标方法之前,模拟开始实务");
        //执行目标方法,并保存目标方法的返回值
        Object rvt = methodProxy.invokeSuper(o,new String[]{"被改变的参数--> "});
        System.out.println("执行目标方法之后,模拟事务结束");
        return rvt + "CGLIB新增的内容";
    }
}
