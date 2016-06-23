package cn.zjcscut.aop.action;

import cn.zjcscut.aop.anno.AspectJ;
import cn.zjcscut.aop.base.BaseAspect;

/**
 * @author zhangjinci
 * @version 2016/6/23 10:16
 */

@AspectJ(packages = "cn.zjcscut.aop.sample",clazz = "Simple")
public class ProduceActionAspect extends BaseAspect {

    @Override
    protected Object advice(PointCut pointCut, Object proxy, Object[] args) {
        long begin = System.currentTimeMillis();
        Object result = pointCut.invoke(proxy, args);
        System.out.println("total time--> " + (System.currentTimeMillis() - begin));
        return result;
    }
}
