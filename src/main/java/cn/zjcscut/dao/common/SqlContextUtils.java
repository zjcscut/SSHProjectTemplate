package cn.zjcscut.dao.common;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/6/24 15:13
 */
public class SqlContextUtils {

    private Criteria criteria = null;

    public SqlContextUtils() {
    }

    public static SqlContextUtils getInstance(Criteria criteria) {
        return new SqlContextUtils(criteria);
    }

    public SqlContextUtils(Criteria criteria) {
        this();
        this.criteria = criteria;
    }

    //有个比较坑的地方，hibernate内部不会自动强转参数，例如实体的一个属性为Integer类型
    //如果作为参数人为地写入为String类型，作为查询参数时候会抛出ClassCastException


    private static final String IN_SEPARATOR = ","; //IN 查询的分隔符

    private static final String STRING_SEPARATOR_SEMICOLON = ";"; // 查询的分隔符

    private static final String STRING_SEPARATOR_COMMA = ","; // 查询的分隔符

    public void buildEqualCriteriaByParams(Map<String, Object> params) {
        buildEqualCriteriaByParams(params, null);
    }

    public void buildEqualCriteriaByParamsStringOrder(Map<String, Object> params, String orderBy) {
        buildEqualCriteriaByParams(params, stringToMap(orderBy));
    }


    //重载一个方法，默认params中key为filed，value为field的value，symbol默认为"="
    public void buildEqualCriteriaByParams(Map<String, Object> params, Map<String, String> orderBy) {
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                buildEqualCriteria(entry.getValue(), entry.getKey());
            }
        }
        if (orderBy != null) {
            for (Map.Entry<String, String> entry : orderBy.entrySet()) {
                buildOrderByCriteria(entry.getKey(), entry.getValue());
            }
        }
    }

    //重载一个方法，一个Map记录所有的传入参数key以及value，另一个Map作为filter使用，
    // key为需要特殊操作的filed的名称，value为特殊操作的名称，如"like"
    public void buildCriteriaByParams(Map<String, Object> params, Map<String, String> filter) {
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (filter != null && !filter.containsKey(entry.getKey())) {
                    buildEqualCriteria(entry.getValue(), entry.getKey());
                } else if (filter != null && filter.containsKey(entry.getKey())) {
                    buildCriteriaByParams(params,
                            entry.getKey(),
                            entry.getKey(),
                            filter.get(entry.getKey()));
                }
            }
        }
    }

    //重载方法，加入排序Map
    public void buildCriteriaByParams(Map<String, Object> params, Map<String, String> filter, Map<String, String> orderBy) {
        buildCriteriaByParams(params, filter);
        for (Map.Entry<String, String> entry : orderBy.entrySet()) {
            buildOrderByCriteria(entry.getKey(), entry.getValue());
        }
    }

    //重载方法，加入排序String，key-value之间用";"分隔
    public void buildCriteriaByParams(Map<String, Object> params, Map<String, String> filter, String orderBy) {
        buildCriteriaByParams(params, filter);
        Map<String, String> map = stringToMap(orderBy);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                buildOrderByCriteria(entry.getKey(), entry.getValue());
            }
        }
    }


    public void buildCriteriaByParams(Map<String, Object> params,
                                      String paramName,
                                      String field,
                                      String symbol) {
        if (params != null && !params.isEmpty()) {
            Object paramVal = params.get(paramName);
            if (paramVal != null) {
                if (StringUtils.isBlank(symbol)) {
                    buildEqualCriteria(paramVal, field);
                } else if ("LIKE".equalsIgnoreCase(symbol)) {
                    buildLikeCriteria(paramVal, field);
                } else if ("LLIKE".equalsIgnoreCase(symbol)) {
                    buildLikeLeftCriteria(paramVal, field);
                } else if ("RLIKE".equalsIgnoreCase(symbol)) {
                    buildLikeRightCriteria(paramVal, field);
                } else if ("OR".equalsIgnoreCase(symbol)) {
                    buildOrCriteria(paramVal, field);
                } else if ("INTEGERIN".equalsIgnoreCase(symbol)) {
                    buildIntegerInCriteria(paramVal, field);
                } else if ("STRINGIN".equalsIgnoreCase(symbol)) {
                    buildStringInCriteria(paramVal, field);
                } else if (">".equals(symbol)) {
                    buildGreatThanCriteria(paramVal, field);
                } else if ("<".equals(symbol)) {
                    buildLessThanCriteria(paramVal, field);
                } else if (">=".equals(symbol)) {
                    buildGreatEqualThanCriteria(paramVal, field);
                } else if ("<=".equals(symbol)) {
                    buildLessEqualThanCriteria(paramVal, field);
                } else {
                    buildEqualCriteria(paramVal, field);
                }
            }
        }
    }

    public SqlContextUtils buildEqualCriteria(Object paramVal, String field) {
        criteria.add(Restrictions.eq(field, paramVal));
        return this;
    }


    public SqlContextUtils buildOrCriteria(Object paramVal, String field) {
        criteria.add(Restrictions.or(Restrictions.eq(field, paramVal)));
        return this;
    }

    public SqlContextUtils buildIntegerInCriteria(Object paramVal, String field) {
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
        return this;
    }

    public SqlContextUtils buildStringInCriteria(Object paramVal, String field) {
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
        return this;
    }

    // 相当于 "%paramVal%"
    public SqlContextUtils buildLikeCriteria(Object paramVal, String field) {
        criteria.add(Restrictions.like(field, paramVal.toString(), MatchMode.ANYWHERE));
        return this;
    }

    // 相当于 "paramVal%"
    public SqlContextUtils buildLikeLeftCriteria(Object paramVal, String field) {
        criteria.add(Restrictions.like(field, paramVal.toString(), MatchMode.START));
        return this;
    }

    // 相当于 "%paramVal"
    public SqlContextUtils buildLikeRightCriteria(Object paramVal, String field) {
        criteria.add(Restrictions.like(field, paramVal.toString(), MatchMode.END));
        return this;
    }

    //相当于"<"
    public SqlContextUtils buildLessThanCriteria(Object paramVal, String field) {
        criteria.add(Restrictions.lt(field, paramVal));
        return this;
    }

    //相当于">"
    public SqlContextUtils buildLessEqualThanCriteria(Object paramVal, String field) {
        criteria.add(Restrictions.le(field, paramVal));
        return this;
    }

    //相当于">="
    public SqlContextUtils buildGreatThanCriteria(Object paramVal, String field) {
        criteria.add(Restrictions.gt(field, paramVal));
        return this;
    }

    //相当于"<="
    public SqlContextUtils buildGreatEqualThanCriteria(Object paramVal, String field) {
        criteria.add(Restrictions.ge(field, paramVal));
        return this;
    }

    //相当于between
    public SqlContextUtils buildBetweenCriteria(String field, Object preField, Object endField) {
        criteria.add(Restrictions.between(field, preField, endField));
        return this;
    }

    //设置排序
    public SqlContextUtils buildOrderByCriteria(String filed, String key) {
        if ("ASC".equalsIgnoreCase(key)) {
            criteria.addOrder(Order.asc(filed));
        } else {
            criteria.addOrder(Order.desc(filed));
        }
        return this;
    }

    //把String数组转化为Object数组
    private static Object[] stringArrayToInt(String[] stringArray) {
        Object[] re = new Object[stringArray.length];
        for (int i = 0, length = stringArray.length; i < length; i++) {
            re[i] = Integer.parseInt(stringArray[i]);
        }
        return re;
    }

    //把String按规则分割放进一个Map
    private static Map<String, String> stringToMap(String orderBy) {
        String[] entries = orderBy.split(STRING_SEPARATOR_SEMICOLON);
        if (entries.length > 0) {
            Map<String, String> map = new HashMap<>();
            for (String entry : entries
                    ) {
                String[] single = entry.split(STRING_SEPARATOR_COMMA);
                map.put(single[0], single[1]);
            }
            return map;
        }
        return null;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }
}
