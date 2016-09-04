/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.db.annotation.anno;

import java.lang.annotation.*;

/**
 * @author zhangjinci
 * @version 2016/8/22 9:38
 * @function column注解
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {

    String name() default "";

    boolean unique() default false;

    boolean nullable() default true;

    int length() default 20; //长度默认为20，实际上应该根据java类型设置默认值
}
