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
 * @version 2016/8/22 9:37
 * @function 主键注解,可以作用在字段或者方法上
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Id {
}
