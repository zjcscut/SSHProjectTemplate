package cn.zjcscut.aop.base;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangjinci
 * @version 2016/6/23 10:07
 */
public abstract class BaseAspect implements MethodInterceptor {


    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
        return (T) Enhancer.create(clazz, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }

    //增强方法的模板
    protected abstract Object advice(PointCut pointCut, Object proxy, Object[] args);

    protected class PointCut {

        private Method methodTarget;
        private MethodProxy methodProxy;

        public PointCut(MethodProxy methodProxy, Method methodTarget) {
            this.methodProxy = methodProxy;
            this.methodTarget = methodTarget;
        }

        public Method getMethodTarget() {
            return methodTarget;
        }

        public MethodProxy getMethodProxy() {
            return methodProxy;
        }

        public Object invoke(Object proxy, Object[] args) {
            Object result = null;
            try {
                result = methodProxy.invokeSuper(proxy, args);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}
