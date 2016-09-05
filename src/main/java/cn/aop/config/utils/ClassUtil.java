/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.aop.config.utils;

import java.util.Optional;

/**
 * @author zhangjinci
 * @version 2016/9/2 17:09
 * @function
 */
public class ClassUtil {

    /**
     * 获取类加载器
     *
     * @return
     */
    public static ClassLoader getClassLoader() {
        return Optional.ofNullable(Thread.currentThread().getContextClassLoader()).orElse(
                Optional.ofNullable(ClassUtil.class.getClassLoader()).orElse(
                        Optional.ofNullable(ClassLoader.getSystemClassLoader()).orElse(null)
                )
        );
    }

    public static void main(String[] args) {
        System.out.println(getClassLoader());
    }
}
