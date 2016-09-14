package cn.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.alibaba.fastjson.JSON.DEFAULT_GENERATE_FEATURE;

/**
 * @author zjc
 * @version 2016/9/12 22:00
 * @description fastjson工具类
 * <p>
 * 依赖
 * <dependency>
 * <groupId>com.alibaba</groupId>
 * <artifactId>fastjson</artifactId>
 * <version>1.2.17</version>
 * </dependency>
 */
public class FastJsonUtils {

    private FastJsonUtils() {
    }

    private static final Logger log = LoggerFactory.getLogger(FastJsonUtils.class);

    //不过滤空的字段,日期格式化为yyyy-MM-dd HH:mm:ss
    private static final SerializerFeature[] WRITE_NULL = {
            SerializerFeature.WriteDateUseDateFormat
            , SerializerFeature.WriteMapNullValue
            , SerializerFeature.WriteNullNumberAsZero
            , SerializerFeature.WriteNullListAsEmpty
            , SerializerFeature.WriteNullStringAsEmpty};

    //过滤空的字段,日期格式化为yyyy-MM-dd HH:mm:ss
    private static final SerializerFeature[] IGNORE_NULL = {
            SerializerFeature.WriteDateUseDateFormat};

    /**
     * json字符串转化为Map<String,Object>
     *
     * @param jsonStr str
     * @return map
     */
    public static Map<String, Object> toMap(final String jsonStr) {
        if (null == jsonStr || 0 == jsonStr.length()) {
            return null;
        }
        Map<String, Object> map = null;
        try {
            map = JSON.parseObject(jsonStr,
                    new TypeReference<Map<String, Object>>() {
                    });
        } catch (Exception e) {
            log.error("converte json string to Map<String,Object> failed:" + e.getMessage());
        }
        return map;
    }

    /**
     * json字符串转化为Map<String,String>
     *
     * @param jsonStr str
     * @return map
     */
    public static Map<String, String> toMapS(final String jsonStr) {
        if (null == jsonStr || 0 == jsonStr.length()) {
            return null;
        }
        Map<String, String> map = null;
        try {
            map = JSON.parseObject(jsonStr,
                    new TypeReference<Map<String, String>>() {
                    });
        } catch (Exception e) {
            log.error("converte json string to Map<String,String> failed:" + e.getMessage());
        }
        return map;
    }

    /**
     * json字符串转换成javaBean
     *
     * @param jsonStr s
     * @param clazz   c
     * @param <T>     t
     * @return t
     */
    public static <T> T toBean(final String jsonStr, Class<T> clazz) {
        if (null == jsonStr || 0 == jsonStr.length()) {
            return null;
        }
        T t = null;
        try {
            t = JSON.parseObject(jsonStr, clazz);
        } catch (Exception e) {
            log.error("converte json string to <{}> failed:{}", clazz.getName(), e.getMessage());
        }
        return t;
    }

    /**
     * json字符串转化为List javaBean
     *
     * @param jsonStr s
     * @param clazz   c
     * @param <T>     t
     * @return t
     */
    public static <T> List<T> toBeanList(final String jsonStr, Class<T> clazz) {
        if (null == jsonStr || 0 == jsonStr.length()) {
            return Collections.emptyList();
        }
        List<T> list = null;
        try {
            list = JSON.parseArray(jsonStr, clazz);
        } catch (Exception e) {
            log.error("converte json string to List<{}> failed:{}", clazz.getName(), e.getMessage());
        }
        return list;
    }

    /**
     * json字符串转化为List<Map>
     *
     * @param jsonStr j
     * @return l
     */
    public static List<Map<String, Object>> toMapList(final String jsonStr) {
        if (null == jsonStr || 0 == jsonStr.length()) {
            return Collections.emptyList();
        }
        List<Map<String, Object>> list = null;
        try {
            list = JSON.parseObject(jsonStr, new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (Exception e) {
            log.error("converte json string to List<Map<String,Object>> failed:{}", e.getMessage());
        }
        return list;
    }


    /**
     * json字符串转化为List<Map>
     *
     * @param jsonStr j
     * @return l
     */
    public static List<Map<String, String>> toMapListS(final String jsonStr) {
        if (null == jsonStr || 0 == jsonStr.length()) {
            return Collections.emptyList();
        }
        List<Map<String, String>> list = null;
        try {
            list = JSON.parseObject(jsonStr, new TypeReference<List<Map<String, String>>>() {
            });
        } catch (Exception e) {
            log.error("converte json string to List<Map<String,String>> failed:{}", e.getMessage());
        }
        return list;
    }

    /**
     * 对象转化为json字符串
     *
     * @param o o
     * @return s
     */
    public static String toJson(final Object o) {
        return JSON.toJSONString(o);
    }

    /**
     * 对象转化为json字符串
     *
     * @param o           o
     * @param dateFormate 日期格式
     * @return s
     */
    public static String toJson(final Object o, String dateFormate) {
        return toJson(o, null, null, true, dateFormate);
    }


    /**
     * 对象转化为json字符串
     *
     * @param o           o
     * @param dateFormate 日期格式
     * @param ignoreNull  是否忽略null
     * @return s
     */
    public static String toJson(final Object o, String dateFormate, boolean ignoreNull) {
        return toJson(o, null, null, ignoreNull, dateFormate);
    }

    /**
     * 对象转化为json字符串
     *
     * @param o             o
     * @param excludeFields 屏蔽的字段key集合
     * @return s
     */
    public static String toJsonX(final Object o, Collection<String> excludeFields) {
        return toJson(o, null, excludeFields, true, null);
    }

    /**
     * 对象转化为json字符串
     *
     * @param o             o
     * @param excludeFields 屏蔽的字段key集合
     * @param ignoreNull    是否忽略null
     * @return s
     */
    public static String toJsonX(final Object o, Collection<String> excludeFields, boolean ignoreNull) {
        return toJson(o, null, excludeFields, ignoreNull, null);
    }

    /**
     * 对象转化为json字符串
     *
     * @param o             o
     * @param excludeFields 屏蔽的字段key集合
     * @param dateFormate   日期格式
     * @return s
     */
    public static String toJsonX(final Object o, Collection<String> excludeFields, String dateFormate) {
        return toJson(o, null, excludeFields, true, dateFormate);
    }

    /**
     * 对象转化为json字符串
     *
     * @param o             o
     * @param excludeFields 屏蔽的字段key集合
     * @param dateFormate   日期格式
     * @param ignoreNull    是否忽略null
     * @return s
     */
    public static String toJsonX(final Object o, Collection<String> excludeFields, String dateFormate, boolean ignoreNull) {
        return toJson(o, null, excludeFields, ignoreNull, dateFormate);
    }

    /**
     * 对象转化为json字符串
     *
     * @param o             o
     * @param includeFields 包含的字段key集合
     * @return s
     */
    public static String toJsonI(final Object o, Collection<String> includeFields) {
        return toJson(o, includeFields, null, true, null);
    }

    /**
     * 对象转化为json字符串
     *
     * @param o             o
     * @param includeFields 包含的字段key集合
     * @param dateFormate   日期格式
     * @return s
     */
    public static String toJsonI(final Object o, Collection<String> includeFields, String dateFormate) {
        return toJson(o, includeFields, null, true, dateFormate);
    }

    /**
     * 对象转化为json字符串
     *
     * @param o             o
     * @param includeFields 包含的字段key集合
     * @param ignoreNull    是否忽略null
     * @return s
     */
    public static String toJsonI(final Object o, Collection<String> includeFields, boolean ignoreNull) {
        return toJson(o, includeFields, null, ignoreNull, null);
    }

    /**
     * 对象转化为json字符串
     *
     * @param o             o
     * @param includeFields 包含的字段key集合
     * @param dateFormate   日期格式
     * @param ignoreNull    是否忽略null
     * @return s
     */
    public static String toJsonI(final Object o, Collection<String> includeFields, String dateFormate, boolean ignoreNull) {
        return toJson(o, includeFields, null, ignoreNull, dateFormate);
    }

    /**
     * 对象转化为json字符串
     *
     * @param o             o
     * @param includeFields 包含的字段key集合
     * @param excludeFields 屏蔽的字段key集合
     * @param ignoreNull    是否忽略null
     * @param dateFormate   日期格式
     * @return s
     */
    public static String toJson(final Object o, Collection<String> includeFields, Collection<String> excludeFields, boolean ignoreNull, String dateFormate) {
        SimplePropertyPreFilter sp = new SimplePropertyPreFilter();
        if (includeFields != null && !includeFields.isEmpty()) {
            for (String s : includeFields) {
                sp.getIncludes().add(s);
            }
        }
        if (excludeFields != null && !excludeFields.isEmpty()) {
            for (String s : excludeFields) {
                sp.getExcludes().add(s);
            }
        }
        if (ignoreNull) {
            if (null == dateFormate || 0 == dateFormate.length()) {
                return JSON.toJSONString(o, sp, IGNORE_NULL);
            } else {
                return JSON.toJSONString(o, SerializeConfig.globalInstance, new SimplePropertyPreFilter[]{sp}, dateFormate, DEFAULT_GENERATE_FEATURE, IGNORE_NULL);
            }
        } else {
            if (null == dateFormate || 0 == dateFormate.length()) {
                return JSON.toJSONString(o, sp, WRITE_NULL);
            } else {
                return JSON.toJSONString(o, SerializeConfig.globalInstance, new SimplePropertyPreFilter[]{sp}, dateFormate, DEFAULT_GENERATE_FEATURE, WRITE_NULL);
            }
        }
    }

}
