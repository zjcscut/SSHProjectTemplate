package cn.ppfix.common.annotation.impl;

import cn.ppfix.common.annotation.JsonResponse;
import cn.ppfix.utils.JsonUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zjc
 * @version 2016/6/9 19:26
 * @function AOP实现Spring Controller返回值转化为Json格式,注意添加@ResponseBody
 */
@Component
@Aspect
public class JsonResponseHandler {

	private static final Logger log = LogManager.getLogger(JsonUtil.class);
	/**
	 * 依赖于spring aop和fastJson，下面序列化特性可以自行修改
	 */

	/**
	 * 特性: (1)格式化日期:yyyy-MM-dd HH:mm:ss
	 * (2)把map里面的空值输出为null
	 * (3)把为null的数字输出为0
	 * (4)把为null的List输出为""
	 * (5)把为null的字符串输出为""
	 */
	private static final SerializerFeature[] WriteNullValueFeatures = {
			SerializerFeature.WriteDateUseDateFormat
			, SerializerFeature.WriteMapNullValue
			, SerializerFeature.WriteNullNumberAsZero
			, SerializerFeature.WriteNullListAsEmpty
			, SerializerFeature.WriteNullStringAsEmpty};

	/**
	 * 特性: 格式化日期:yyyy-MM-dd HH:mm:ss
	 */
	private static final SerializerFeature[] Features = {
			SerializerFeature.WriteDateUseDateFormat};

	//class切点
	@Pointcut("@within(cn.ppfix.common.annotation.JsonResponse)")
	public void classPointCut() {
	}

	//method切点
	@Pointcut("@annotation(cn.ppfix.common.annotation.JsonResponse)")
	public void methodPointCut() {
	}

	//切点为所有使用了@JsonResponse的类或者方法
	@Around("classPointCut() || methodPointCut()")
	public Object JsonResponseAccess(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = pjp.proceed();
		if (obj == null) {
			return null;
		}
		log.debug("进入Json注解处理器");
		Object target = pjp.getTarget();
//		String method = pjp.getSignature().getName();
		Class<?> clazz = target.getClass();
		//获取当前执行的方法
		Method m = ((MethodSignature) pjp.getSignature()).getMethod();
		if (clazz != null && m != null) {
			boolean isClzAnnotation = clazz.isAnnotationPresent(JsonResponse.class);
			boolean isMethondAnnotation = m.isAnnotationPresent(JsonResponse.class);
			//如果类中和方法中同时标注注解，方法中的注解覆盖类中的设置
			JsonResponse jr = null;
			if (isMethondAnnotation) {
				jr = m.getAnnotation(JsonResponse.class);
			} else if (isClzAnnotation) {
				jr = clazz.getAnnotation(JsonResponse.class);
			}else {
				return obj;  //不存在注解
			}

			if (jr != null) {
				boolean isIgnoreNull = jr.ignoreNull();
				String[] includeFilter = jr.includeFilter();
				String[] excludeFilter = jr.exculdeFilter();
				SimplePropertyPreFilter sp = new SimplePropertyPreFilter();
				if (includeFilter.length > 0) {
					for (String pro : includeFilter
							) {
						sp.getIncludes().add(pro);
					}
				}
				if (excludeFilter.length > 0) {
					for (String pro : excludeFilter
							) {
						sp.getExcludes().add(pro);
					}
				}
				log.debug("Json转换完毕，返回Json值");
				if (includeFilter.length > 0 || excludeFilter.length > 0) {
					if (isIgnoreNull) {
						return JSON.toJSONString(obj, sp, Features);
					} else {
						return JSON.toJSONString(obj, sp, WriteNullValueFeatures);
					}
				} else {
					if (isIgnoreNull) {
						return JSON.toJSONString(obj, Features);
					} else {
						return JSON.toJSONString(obj, WriteNullValueFeatures);
					}
				}
			}
			//不经过注解处理流程直接返回
			return obj;
		}
		return obj;
	}
}