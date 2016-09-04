/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.db.annotation.converter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/8/25 14:54
 * @function Oracle数据库字段类型容器
 */
public class OracleTypeContainer {

    private static final Map<Class<?>, String> container = new HashMap<>();

    public OracleTypeContainer() {
    }

    static {

    }

    public static Map<Class<?>, String> getContainer() {
        return container;
    }
}
