/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.db.jdk;

import cn.db.annotation.main.User;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zhangjinci
 * @version 2016/8/22 15:42
 * @function 通过PropertyDescriptor获取bean的方法
 */
public class PropertyDescriptorDemo {

    public Object get(String propertyName) {
        Object re = null;
        User user = new User(1, "zjcscut", new Date());
        try {
            PropertyDescriptor pd = new PropertyDescriptor(propertyName, user.getClass());
            Method readMethod = pd.getReadMethod();
            re = readMethod.invoke(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(new PropertyDescriptorDemo().get("name"));
        System.out.println(new PropertyDescriptorDemo().get("id"));
        System.out.println(new PropertyDescriptorDemo().get("birth"));
        //没有此属性会抛出异常java.beans.IntrospectionException: Method not found: isBirthss，并且返回null
        System.out.println(new PropertyDescriptorDemo().get("birthss"));
    }
}
