/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.util.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;

/**
 * @author zhangjinci
 * @version 2016/9/19 18:38
 * @function 反射相关工具类
 */
public class ReflectionUtils {

    private static final Logger log = LoggerFactory.getLogger(ReflectionUtils.class);

    /**
     * 抑制JVM对修饰符的检查
     *
     * @param o o
     */
    public static void makeAccessible(Object o) {
        if (null != o) {
            if (o instanceof Method) {
                makeAccessible((Method) o);
            } else if (o instanceof Constructor<?>) {
                makeAccessible((Constructor<?>) o);
            } else if (o instanceof Field) {
                makeAccessible((Field) o);
            } else if (o instanceof AccessibleObject) {
                ((AccessibleObject) o).setAccessible(true);
            }
        }
    }


   private static void makeAccessible(Field field) {
        if (!Modifier.isPublic(field.getModifiers()) ||
                !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            field.setAccessible(true);
        }
    }

    private static void makeAccessible(Method method) {
        if (!Modifier.isPublic(method.getModifiers()) ||
                !Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            method.setAccessible(true);
        }
    }

    private static void makeAccessible(Constructor<?> ctor) {
        if (!Modifier.isPublic(ctor.getModifiers()) ||
                !Modifier.isPublic(ctor.getDeclaringClass().getModifiers())) {
            ctor.setAccessible(true);
        }
    }


    /**
     * 判断两个Class<?> 是否相同或者是否父类和子类的关系
     *
     * @param o o
     * @param t t
     * @return boolean
     */
    public static boolean isAssignable(Class<?> o, Class<?> t) {
        return o != null && t != null && o.isAssignableFrom(t);
    }

    //获取修饰符整型值
    public static int getModifiers(Member member) {
        return member.getModifiers();
    }

    //获取修饰符名称
    public static String getModifiersName(Member member) {
        return Modifier.toString(member.getModifiers());
    }

    //获取所有接口(修饰符public)
    public static Constructor<?>[] getConstructors(Class<?> clazz) {
        return clazz.getConstructors();
    }

    //获取单个接口(修饰符public)
    public static Constructor<?> getConstructor(Class<?> clazz, Class<?>[] paramsType) {
        try {
            return clazz.getConstructor(paramsType);
        } catch (NoSuchMethodException e) {
            log.error(String.format("reflect to fetch <%s>.Constructor<?> failed,message:<%s>", clazz.getTypeName(), e.getMessage()));
        }
        return null;
    }

    //获取本类声明的所有接口(所有修饰符)
    public static Constructor<?>[] getDeclaredConstructors(Class<?> clazz) {
        return clazz.getDeclaredConstructors();
    }

    //获取本类声明的单个接口(所有修饰符)
    public static Constructor<?> getDeclaredConstructor(Class<?> clazz, Class<?>[] paramsType) {
        try {
            return clazz.getDeclaredConstructor(paramsType);
        } catch (NoSuchMethodException e) {
            log.error(String.format("reflect to fetch <%s>.Constructor<?> failed,message:<%s>", clazz.getTypeName(), e.getMessage()));
        }
        return null;
    }

    public static Method[] getMethods(Class<?> clazz) {
        return clazz.getMethods();
    }

    public static Method getMethod(Class<?> clazz, String methodName, Class<?>[] paramsType) {
        try {
            return clazz.getMethod(methodName, paramsType);
        } catch (NoSuchMethodException e) {
            log.error(String.format("reflect to fetch <%s>.%s failed,message:<%s>", clazz.getTypeName(), methodName, e.getMessage()));
        }
        return null;
    }

    public static Method[] getDeclaredMethods(Class<?> clazz) {
        return clazz.getDeclaredMethods();
    }

    public static Method getDeclaredMethod(Class<?> clazz, String methodName, Class<?>[] paramsType) {
        try {
            return clazz.getDeclaredMethod(methodName, paramsType);
        } catch (NoSuchMethodException e) {
            log.error(String.format("reflect to fetch <%s>.%s failed,message:<%s>", clazz.getTypeName(), methodName, e.getMessage()));
        }
        return null;
    }
}
