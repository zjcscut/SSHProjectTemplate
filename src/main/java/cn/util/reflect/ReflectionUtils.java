/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.util.reflect;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author zhangjinci
 * @version 2016/9/19 18:38
 * @function 反射相关工具类
 * <p>
 * 依赖：
 * <dependency>
 * <groupId>org.apache.commons</groupId>
 * <artifactId>commons-lang3</artifactId>
 * <version>3.4</version>
 * </dependency>
 */
public class ReflectionUtils {

    private static final Logger log = LoggerFactory.getLogger(ReflectionUtils.class);

    //抑制JVM对修饰符的检查
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

    public static Class<?> getInstanceClass(String className) {
        Validate.notNull(className, "Class name must not null");
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error(String.format("reflect to instance as Class %s failed,message:<%s>", className, e.getMessage()));
            handleReflectionException(e);
        }
        return null;
    }

    public static Object getInstance(Class<?> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error(String.format("reflect to instance %s failed,message:<%s>", clazz.getCanonicalName(), e.getMessage()));
            handleReflectionException(e);
        }
        return null;
    }

    public static Object getInstance(String className){
        return getInstance(getInstanceClass(className));
    }


    //判断两个Class<?> 是否相同或者是否父类和子类的关系
    public static boolean isAssignable(Class<?> o, Class<?> t) {
        return o != null && t != null && o.isAssignableFrom(t);
    }

    public static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive();
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
            handleReflectionException(e);
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
            handleReflectionException(e);
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
            handleReflectionException(e);
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
            handleReflectionException(e);
        }
        return null;
    }

    //1.调用getMethods方法输出的是自身的public方法和父类Object的public方法。调用getDeclaredMethods方法输出的是自身的public、protected、private方法。
    //2.如果想获取父类的私有函数需要把Class<?>对象转化为父类的对象,然后使用getDeclaredMethods方法
    public static Method findMethod(Class<?> clazz, String name, Class<?>[] paramsType) {
        Validate.notNull(clazz, "Class must not null");
        Validate.notNull(name, "Method name must be specified");
        Class<?> searchType = clazz;
        while (null != searchType && Object.class != searchType) {
            Method[] methods = (searchType.isInterface() ? getMethods(searchType) : getDeclaredMethods(searchType));
            for (Method method : methods) {
                if (name.equals(method.getName()) &&
                        (paramsType == null || Arrays.equals(paramsType, method.getParameterTypes()))) {
                    return method;
                }
            }
            searchType = searchType.getSuperclass();//Class<?>转化为父类对象
        }
        return null;
    }

    public static Field[] getFields(Class<?> clazz) {
        return clazz.getFields();
    }

    public static Field getField(Class<?> clazz, String name) {
        try {
            return clazz.getField(name);
        } catch (NoSuchFieldException e) {
            log.error(String.format("reflect to fetch <%s> Field %s failed,message:<%s>", clazz.getTypeName(), name, e.getMessage()));
            handleReflectionException(e);
        }
        return null;
    }

    public static Field[] getDeclaredFields(Class<?> clazz) {
        return clazz.getDeclaredFields();
    }

    public static Field getDeclaredField(Class<?> clazz, String name) {
        try {
            return clazz.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            log.error(String.format("reflect to fetch <%s> Field %s failed,message:<%s>", clazz.getTypeName(), name, e.getMessage()));
            handleReflectionException(e);
        }
        return null;
    }

    public static Field findField(Class<?> clazz, String name) {
        return findField(clazz, name, null);
    }

    //1.调用getFeilds方法输出的是自身的public方法和父类Object的public方法。调用getDeclaredFields方法输出的是自身的public、protected、private方法。
    //2.如果想获取父类的私有函数需要把Class<?>对象转化为父类的对象,然后使用getDeclaredFields方法
    public static Field findField(Class<?> clazz, String name, Class<?> type) {
        Validate.notNull(clazz, "Class must not null");
        Validate.isTrue(name != null || type != null, "Either name or type of the field must be specified");
        Class<?> searchType = clazz;
        while (null != searchType && Object.class != searchType) {
            Field[] fields = getDeclaredFields(searchType);
            for (Field f : fields) {
                if ((null == name || name.equals(f.getName())) && (null == type || type.equals(f.getType()))) {
                    return f;
                }
            }
            searchType = searchType.getSuperclass(); //Class<?>转化为父类对象
        }
        return null;
    }

    public static void setField(String fieldName, String className, Object value) {
        Class<?> c = getInstanceClass(className);
        Field f = findField(c, fieldName);
        setField(f, c, value);
    }

    public static void setField(String fieldName, Object target, Object value) {
        Field f = findField(target.getClass(), fieldName);
        setField(f, target, value);
    }


    public static void setField(Field field, Object target, Object value) {
        Validate.notNull(field, "Field must not null");
        Validate.notNull(target, "Target must not null");
        try {
            makeAccessible(field);
            field.set(target, value);
        } catch (IllegalAccessException e) {
            log.error(String.format("reflect to set <%s> Field %s valueOf %s failed,message:<%s>", target.getClass().getTypeName(), field.getName(), value, e.getMessage()));
            handleReflectionException(e);
        }
    }

    public static Object getField(String fieldName, Object target) {
        return findField(target.getClass(), fieldName);
    }

    public static Object getField(Field field, Object target) {
        Validate.notNull(field, "Field must not null");
        Validate.notNull(target, "Target must not null");
        try {
            return field.get(target);
        } catch (IllegalAccessException ex) {
            log.error(String.format("reflect to get <%s> Field %s failed,message:<%s>", target.getClass().getTypeName(), field.getName(), ex.getMessage()));
            handleReflectionException(ex);
        }
        return null;
    }

    public static Object getField(String fieldName, String className) {
        Class<?> c = getInstanceClass(className);
        Field f = findField(c, fieldName);
        return getField(f, c);
    }

    public static Object invokeMethod(Method method, Object target) {
        return invokeMethod(method, target, null);
    }

    public static Object invokeMethod(Method method, Object target, Object[] args) {
        try {
            return method.invoke(target, args);
        } catch (Exception ex) {
            log.error(String.format("reflect to invoke <%s>.%s failed,message:<%s>", target.getClass().getTypeName(), method.getName(), ex.getMessage()));
            handleReflectionException(ex);
        }
        throw new IllegalStateException("Should never get here");
    }

    public static boolean isPublic(Member member) {
        return Modifier.isPublic(member.getModifiers());
    }

    public static boolean isStatic(Member member) {
        return Modifier.isStatic(member.getModifiers()) ;
    }

    public static boolean isFinal(Member member) {
        return Modifier.isFinal(member.getModifiers());
    }

    public static boolean isPrivate(Member member) {
        return Modifier.isPrivate(member.getModifiers());
    }

    public static boolean isProtected(Member member) {
        return Modifier.isProtected(member.getModifiers());
    }

    public static boolean isPublicStaticFinal(Member member) {
        return isPublic(member) && isStatic(member) && isFinal(member);
    }

    public static boolean isEqualsMethod(Method method) {
        if (null == method || !"equals".equals(method.getName())) {
            return false;
        }
        Class<?>[] paramTypes = method.getParameterTypes();
        return paramTypes.length == 1 && paramTypes[0] == Object.class;
    }

    public static boolean isHashCodeMethod(Method method) {
        return null != method && "hashCode".equals(method.getName()) && 0 == method.getTypeParameters().length;
    }

    public static boolean isToStringMethod(Method method) {
        return null != method && "toString".equals(method.getName()) && 0 == method.getTypeParameters().length;
    }

    //获取getXXX的值,XXX为propertyName(getter方法)
    public static Object getReadValue(Object target, String propertyName) {
        try {
            PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, target.getClass());
            Method method = descriptor.getReadMethod();
            if (method != null) {
                return method.invoke(target);
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            log.error("invoke getter method failed,message:" + e.getMessage());
            handleReflectionException(e);
        }
        return null;
    }

    public static Object getReadValue(Class<?> clazz, String propertyName) {
        return getReadValue(getInstance(clazz), propertyName);
    }

    //设置setXXX的值,XXX为propertyName(setter方法),value为设置的值
    public static void setWriteValue(Object target, String propertyName, Object value) {
        try {
            PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, target.getClass());
            Method method = descriptor.getWriteMethod();
            if (method != null) {
                method.invoke(target, value);
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            log.error("invoke setter method failed,message:" + e.getMessage());
            handleReflectionException(e);
        }
    }

    public static void setWriteValue(Class<?> clazz, String propertyName, Object value) {
        setWriteValue(getInstance(clazz), propertyName, value);
    }






    private static void handleReflectionException(Exception e) {
        if (e instanceof NoSuchMethodException) {
            throw new IllegalStateException("Method not found: " + e.getMessage());
        }
        if (e instanceof NoSuchFieldException) {
            throw new IllegalStateException("Field not found: " + e.getMessage());
        }
        if (e instanceof IllegalAccessException) {
            throw new IllegalStateException("Access field failed: " + e.getMessage());
        }
        if (e instanceof ClassNotFoundException) {
            throw new IllegalStateException("Class not found: " + e.getMessage());
        }
        if (e instanceof IntrospectionException) {
            throw new IllegalStateException("Access property failed: " + e.getMessage());
        }
        if (e instanceof InvocationTargetException) {
            throw new IllegalStateException("Invoke method failed: " + e.getMessage());
        }
        if (e instanceof RuntimeException) {
            throw (RuntimeException) e;
        }
        throw new UndeclaredThrowableException(e); //未声明的异常
    }
}
