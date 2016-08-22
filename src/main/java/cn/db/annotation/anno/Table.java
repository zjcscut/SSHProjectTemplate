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
 * @version 2016/8/22 9:16
 * @function table注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {

    String value();

    String name() default "";
}
