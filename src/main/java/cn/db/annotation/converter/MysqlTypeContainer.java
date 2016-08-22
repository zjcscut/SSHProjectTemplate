/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.db.annotation.converter;


import java.util.HashMap;
import java.util.Map;
import java.lang.*;
/**
 * @author zhangjinci
 * @version 2016/8/22 18:53
 * @function
 */

public class MysqlTypeContainer {

    private MysqlTypeContainer() {
    }

    private static final Map<Class<?>, String> container = new HashMap<>();

    static {
        container.put(java.util.Date.class, "DATETIME");
        container.put(java.sql.Date.class,"DATE");
        container.put(Long.class,"BIGINT");
        container.put(Integer.class,"INT");
        container.put(String.class,"VARCHAR");
        container.put(Float.class,"FLOAT");
        container.put(Double.class,"DOUBLE");
        container.put(Boolean.class,"BOOLEAN");
    }

    public static Map<Class<?>, String> getContainer() {
        return container;
    }
}
