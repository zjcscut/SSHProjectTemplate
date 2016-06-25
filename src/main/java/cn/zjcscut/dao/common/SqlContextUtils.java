package cn.zjcscut.dao.common;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Map;
import java.util.Set;

/**
 * @author zhangjinci
 * @version 2016/6/24 15:13
 */
public class SqlContextUtils {

    private static final String IN_SEPARATOR = ","; //IN 查询的分隔符


    //重载一个方法，默认params中key为filed，value为field的value，symbol默认为"="
    public static void buildCriteriaByParams(Map<String, String> params,
                                             Criteria criteria) {
        Set<Map.Entry<String, String>> entrys = params.entrySet();
        for (Map.Entry<String, String> entry : entrys) {
            buildEqualCriteria(entry.getValue(), entry.getKey(), criteria);
        }
    }

    //重载一个方法，一个Map记录所有的传入参数key以及value，另一个Map作为filter使用，
    // key为需要特殊操作的filed的名称，value为特殊操作的名称，如"like"
    public static void buildCriteriaByParams(Map<String, String> params,
                                             Map<String, String> filter,
                                             Criteria criteria) {
        Set<Map.Entry<String, String>> entrys = params.entrySet();
        for (Map.Entry<String, String> entry : entrys) {
            if (!filter.containsKey(entry.getKey())) {
                buildEqualCriteria(entry.getValue(), entry.getKey(), criteria);
            }else {
                buildCriteriaByParams(params, entry.getKey(), entry.getKey(), filter.get(entry.getKey()), criteria);
            }
        }
    }


    public static void buildCriteriaByParams(Map<String, String> params,
                                             String paramName,
                                             String field,
                                             String symbol,
                                             Criteria criteria) {
        String paramVal = params.get(paramName);
        if (StringUtils.isNotBlank(paramVal)) {
            paramVal = paramVal.trim();
            if (StringUtils.isEmpty(symbol)) {
                buildEqualCriteria(paramVal, field, criteria);
            } else if ("LIKE".equalsIgnoreCase(symbol)) {
                buildLikeCriteria(paramVal, field, criteria);
            } else if ("LLIKE".equalsIgnoreCase(symbol)) {
                buildLikeLeftCriteria(paramVal, field, criteria);
            } else if ("RLIKE".equalsIgnoreCase(symbol)) {
                buildLikeRightCriteria(paramVal, field, criteria);
            } else if ("OR".equalsIgnoreCase(symbol)) {
                buildOrCriteria(paramVal, field, criteria);
            } else if ("IN".equalsIgnoreCase(symbol)) {
                buildInCriteria(paramVal, field, criteria);
            } else {
                buildEqualCriteria(paramVal, field, criteria);
            }
        }
    }

    public static void buildEqualCriteria(String paramVal, String field, Criteria criteria) {
        criteria.add(Restrictions.eq(field, paramVal));
    }


    public static void buildOrCriteria(String paramVal, String field, Criteria criteria) {
        criteria.add(Restrictions.or(Restrictions.eq(field, paramVal)));
    }

    public static void buildInCriteria(String paramVal, String field, Criteria criteria) {
        Object[] items = paramVal.split(IN_SEPARATOR);
        criteria.add(Restrictions.in(field, items));
    }

    // 相当于 "%paramVal%"
    public static void buildLikeCriteria(String paramVal, String field, Criteria criteria) {
        criteria.add(Restrictions.like(field, paramVal, MatchMode.ANYWHERE));
    }

    // 相当于 "paramVal%"
    public static void buildLikeLeftCriteria(String paramVal, String field, Criteria criteria) {
        criteria.add(Restrictions.like(field, paramVal, MatchMode.START));
    }

    // 相当于 "%paramVal"
    public static void buildLikeRightCriteria(String paramVal, String field, Criteria criteria) {
        criteria.add(Restrictions.like(field, paramVal, MatchMode.END));
    }

    //设置排序
    public static void buildOrderByCriteria(String filed, String key, Criteria criteria) {
        if ("ASC".equalsIgnoreCase(key)) {
            criteria.addOrder(Order.asc(filed));
        } else {
            criteria.addOrder(Order.desc(filed));
        }
    }

    //有个比较坑的地方，hibernate内部不会自动强转参数，例如实体的一个属性为Integer类型
    //如果作为参数人为地写入为String类型，作为查询参数时候会抛出ClassCastException
}
