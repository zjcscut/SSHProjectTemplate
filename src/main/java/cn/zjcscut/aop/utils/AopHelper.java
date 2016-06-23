package cn.zjcscut.aop.utils;

import cn.zjcscut.aop.anno.AspectJ;
import cn.zjcscut.aop.base.BaseAspect;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/6/23 10:26
 */
public class AopHelper {

    static {
        try {
            // 获取带有 @Aspect 注解的类（切面类）
            List<Class<?>> aspectClassList = ClassHelper.getClassListByAnnotation(null,AspectJ.class);
            // 遍历所有切面类
            for (Class<?> aspectClass : aspectClassList) {
                // 获取 @Aspect 注解中的属性值
                AspectJ aspect = aspectClass.getAnnotation(AspectJ.class);
                String pkg = aspect.packages(); // 包名
                String cls = aspect.clazz(); // 类名
                // 初始化目标类列表
                List<Class<?>> targetClassList = new ArrayList<>();
                if (StringUtils.isNotEmpty(pkg) && StringUtils.isNotEmpty(cls)) {
                    // 如果包名与类名均不为空，则添加指定类
                    targetClassList.add(Class.forName(pkg + "." + cls));
                } else {
                    // 否则（包名不为空）添加该包名下所有类
                    targetClassList.addAll(ClassHelper.getClassList(pkg,true));
                }
                // 遍历目标类列表
                if (targetClassList.size() > 0) {
                    // 创建父切面类
                    BaseAspect baseAspect = (BaseAspect) aspectClass.newInstance();
                    for (Class<?> targetClass : targetClassList) {
                        // 获取目标实例
                        Object targetInstance = BeanHelper.getBean(targetClass);
                        // 创建代理实例
                        Object proxyInstance = baseAspect.getProxy(targetClass);
                        // 复制目标实例中的字段到代理实例中
                        for (Field field : targetClass.getDeclaredFields()) {
                            field.setAccessible(true); // 可操作私有字段
                            field.set(proxyInstance, field.get(targetInstance));
                        }
                        // 用代理实例覆盖目标实例
                        BeanHelper.getBeanMap().put(targetClass, proxyInstance);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
