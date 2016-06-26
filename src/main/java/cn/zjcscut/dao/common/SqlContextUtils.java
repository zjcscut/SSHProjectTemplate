package cn.zjcscut.dao.common;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangjinci
 * @version 2016/6/24 15:13
 */
public class SqlContextUtils {

	//有个比较坑的地方，hibernate内部不会自动强转参数，例如实体的一个属性为Integer类型
	//如果作为参数人为地写入为String类型，作为查询参数时候会抛出ClassCastException


	private static final String IN_SEPARATOR = ","; //IN 查询的分隔符


	//重载一个方法，默认params中key为filed，value为field的value，symbol默认为"="
	public static void buildCriteriaByParams(Map<String, Object> params,
											 Criteria criteria) {
		Set<Map.Entry<String, Object>> entrys = params.entrySet();
		for (Map.Entry<String, Object> entry : entrys) {
			buildEqualCriteria(entry.getValue(), entry.getKey(), criteria);
		}
	}

	//重载一个方法，一个Map记录所有的传入参数key以及value，另一个Map作为filter使用，
	// key为需要特殊操作的filed的名称，value为特殊操作的名称，如"like"
	public static void buildCriteriaByParams(Map<String, Object> params,
											 Map<String, String> filter,
											 Criteria criteria) {
		Set<Map.Entry<String, Object>> entrys = params.entrySet();
		for (Map.Entry<String, Object> entry : entrys) {
			if (!filter.containsKey(entry.getKey())) {
				buildEqualCriteria(entry.getValue(), entry.getKey(), criteria);
			} else {
				buildCriteriaByParams(params,
						entry.getKey(),
						entry.getKey(),
						filter.get(entry.getKey()),
						criteria);
			}
		}
	}


	public static void buildCriteriaByParams(Map<String, Object> params,
											 String paramName,
											 String field,
											 String symbol,
											 Criteria criteria) {
		if (params != null && !params.isEmpty()) {
			Object paramVal = params.get(paramName);
			if (paramVal != null) {
				if (StringUtils.isBlank(symbol)) {
					buildEqualCriteria(paramVal, field, criteria);
				} else if ("LIKE".equalsIgnoreCase(symbol)) {
					buildLikeCriteria(paramVal, field, criteria);
				} else if ("LLIKE".equalsIgnoreCase(symbol)) {
					buildLikeLeftCriteria(paramVal, field, criteria);
				} else if ("RLIKE".equalsIgnoreCase(symbol)) {
					buildLikeRightCriteria(paramVal, field, criteria);
				} else if ("OR".equalsIgnoreCase(symbol)) {
					buildOrCriteria(paramVal, field, criteria);
				} else if ("INTEGERIN".equalsIgnoreCase(symbol)) {
					buildIntegerInCriteria(paramVal, field, criteria);
				} else if ("STRINGIN".equalsIgnoreCase(symbol)) {
					buildStringInCriteria(paramVal, field, criteria);
				} else if (">".equals(symbol)) {
					buildGreatThanCriteria(paramVal, field, criteria);
				} else if ("<".equals(symbol)) {
					buildLessThanCriteria(paramVal, field, criteria);
				} else if (">=".equals(symbol)) {
					buildGreatEqualThanCriteria(paramVal, field, criteria);
				} else if ("<=".equals(symbol)) {
					buildLessEqualThanCriteria(paramVal, field, criteria);
				} else {
					buildEqualCriteria(paramVal, field, criteria);
				}
			}
		}
	}

	public static void buildEqualCriteria(Object paramVal, String field, Criteria criteria) {
		criteria.add(Restrictions.eq(field, paramVal));
	}


	public static void buildOrCriteria(Object paramVal, String field, Criteria criteria) {
		criteria.add(Restrictions.or(Restrictions.eq(field, paramVal)));
	}

	public static void buildIntegerInCriteria(Object paramVal, String field, Criteria criteria) {
		if (paramVal instanceof Object[]) {
			criteria.add(Restrictions.in(field, (Object[]) paramVal));
		} else if (paramVal instanceof Collection<?>) {
			criteria.add(Restrictions.in(field, (Collection<?>) paramVal));
		} else if (paramVal instanceof String) {
			String[] items = paramVal.toString().split(IN_SEPARATOR);
			criteria.add(Restrictions.in(field, stringArrayToInt(items)));
		} else {
			criteria.add(Restrictions.in(field, paramVal));
		}
	}

	public static void buildStringInCriteria(Object paramVal, String field, Criteria criteria) {
		if (paramVal instanceof Object[]) {
			criteria.add(Restrictions.in(field, (Object[]) paramVal));
		} else if (paramVal instanceof Collection<?>) {
			criteria.add(Restrictions.in(field, (Collection<?>) paramVal));
		} else if (paramVal instanceof String) {
			Object[] items = paramVal.toString().split(IN_SEPARATOR);
			criteria.add(Restrictions.in(field, items));
		} else {
			criteria.add(Restrictions.in(field, paramVal));
		}
	}

	// 相当于 "%paramVal%"
	public static void buildLikeCriteria(Object paramVal, String field, Criteria criteria) {
		criteria.add(Restrictions.like(field, paramVal.toString(), MatchMode.ANYWHERE));
	}

	// 相当于 "paramVal%"
	public static void buildLikeLeftCriteria(Object paramVal, String field, Criteria criteria) {
		criteria.add(Restrictions.like(field, paramVal.toString(), MatchMode.START));
	}

	// 相当于 "%paramVal"
	public static void buildLikeRightCriteria(Object paramVal, String field, Criteria criteria) {
		criteria.add(Restrictions.like(field, paramVal.toString(), MatchMode.END));
	}

	//相当于"<"
	public static void buildLessThanCriteria(Object paramVal, String field, Criteria criteria) {
		criteria.add(Restrictions.lt(field, paramVal));
	}

	//相当于">"
	public static void buildLessEqualThanCriteria(Object paramVal, String field, Criteria criteria) {
		criteria.add(Restrictions.le(field, paramVal));
	}

	//相当于">="
	public static void buildGreatThanCriteria(Object paramVal, String field, Criteria criteria) {
		criteria.add(Restrictions.gt(field, paramVal));
	}

	//相当于"<="
	public static void buildGreatEqualThanCriteria(Object paramVal, String field, Criteria criteria) {
		criteria.add(Restrictions.ge(field, paramVal));
	}

	//相当于between
	public static void buildBetweenCriteria(String field, Object preField, Object endField, Criteria criteria) {
		criteria.add(Restrictions.between(field, preField, endField));
	}

	//设置排序
	public static void buildOrderByCriteria(String filed, String key, Criteria criteria) {
		if ("ASC".equalsIgnoreCase(key)) {
			criteria.addOrder(Order.asc(filed));
		} else {
			criteria.addOrder(Order.desc(filed));
		}
	}

	//把String数组转化为Object数组
	private static Object[] stringArrayToInt(String[] stringArray) {
		Object[] re = new Object[stringArray.length];
		for (int i = 0, length = stringArray.length; i < length; i++) {
			re[i] = Integer.parseInt(stringArray[i]);
		}
		return re;
	}

}
