package cn.zjcscut.aop.anno;

import java.lang.annotation.*;

/**
 * @author zhangjinci
 * @version 2016/6/23 11:08
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {
}
