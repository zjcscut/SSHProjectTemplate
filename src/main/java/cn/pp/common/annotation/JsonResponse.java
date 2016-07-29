package cn.pp.common.annotation;

import java.lang.annotation.*;

/**
 * @author zjc
 * @version 2016/6/9 19:01
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JsonResponse {

	boolean ignoreNull() default true;

	String[] includeFilter() default {};

	String[] exculdeFilter() default {};
}
