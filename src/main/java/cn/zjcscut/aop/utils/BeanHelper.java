package cn.zjcscut.aop.utils;

import cn.zjcscut.aop.anno.Bean;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/6/23 11:07
 */
public class BeanHelper {
    private static final Map<Class<?>, Object> beanMap = new HashMap<>();

//    static {
//        try {
//            // 获取并遍历所有的 Bean（带有 @Bean 注解的类）
//            List<Class<?>> beanClassList = ClassHelper.getClassListByAnnotation(Bean.class);
//            for (Class<?> beanClass : beanClassList) {
//                // 创建 Bean 实例
//                Object beanInstance = beanClass.newInstance();
//                // 将 Bean 实例放入 Bean Map 中（键为 Bean 类，值为 Bean 实例）
//                beanMap.put(beanClass, beanInstance);
//            }
//
//            // 遍历 Bean Map
//            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
//                // 获取 Bean 类与 Bean 实例
//                Class<?> beanClass = beanEntry.getKey();
//                Object beanInstance = beanEntry.getValue();
//                // 获取 Bean 类中所有的字段（不包括父类中的方法）
//                Field[] beanFields = beanClass.getDeclaredFields();
//                if (ArrayUtil.isNotEmpty(beanFields)) {
//                    // 遍历所有的 Bean 字段
//                    for (Field beanField : beanFields) {
//                        // 判断当前 Bean 字段是否带有 @Inject 注解
//                        if (beanField.isAnnotationPresent(Inject.class)) {
//                            // 获取 Bean 字段对应的接口
//                            Class<?> interfaceClass = beanField.getType();
//                            // 获取该接口所有的实现类
//                            List<Class<?>> implementClassList = ClassHelper.getClassListByInterface(interfaceClass);
//                            if (CollectionUtil.isNotEmpty(implementClassList)) {
//                                // 获取第一个实现类
//                                Class<?> implementClass = implementClassList.get(0);
//                                // 从 Bean Map 中获取该实现类对应的实现类实例
//                                Object implementInstance = beanMap.get(implementClass);
//                                // 设置该 Bean 字段的值
//                                beanField.setAccessible(true); // 必须使该字段可访问
//                                beanField.set(beanInstance, implementInstance);
//                            }
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

   public static Map<Class<?>, Object> getBeanMap() {
        return beanMap;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls) {
        return (T) beanMap.get(cls);
    }
}