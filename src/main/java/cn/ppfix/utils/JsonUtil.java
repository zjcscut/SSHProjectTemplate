package cn.ppfix.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @version 2016/1/19-14:48
 */
public class JsonUtil {

	private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
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


	/**
	 * object转化为Json字符串,不保留空值，修正日期表示
	 *
	 * @param object
	 * @return
	 */
	public static String toJson(final Object object) {
		if (null != object)
			return JSON.toJSONString(object, Features);
		else
			return null;
	}


	/**
	 * object转化为Json字符串,保留空值，修正日期表示
	 *
	 * @param object
	 * @return
	 */
	public static String toJsonWithNull(final Object object) {
		if (null != object)
			return JSON.toJSONString(object, WriteNullValueFeatures);
		else
			return null;
	}


	/**
	 * 用fastjson 将json字符串解析为一个 JavaBean
	 *
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T getBean(final String jsonString, Class<T> cls) {
		if ("".equals(jsonString) || jsonString == null) {
			return null;
		} else {
			T t = null;
			try {
				t = JSON.parseObject(jsonString, cls);
			} catch (Exception e) {
				log.error("json to javabean failed");
				e.printStackTrace();
			}
			return t;
		}
	}

	/**
	 * 用fastjson 将json字符串 解析成为一个 List<JavaBean> 及 List<String>
	 *
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> getBeans(final String jsonString, Class<T> cls) {
		if ("".equals(jsonString) || jsonString == null) {
			return null;
		} else {
			List<T> list = new ArrayList<>();
			try {
				list = JSON.parseArray(jsonString, cls);
			} catch (Exception e) {
				log.error("json to List<javabean> failed");
				e.printStackTrace();
			}
			return list;
		}
	}


	/**
	 * 用fastjson 将jsonString 解析成 List<Map<String,Object>>
	 *
	 * @param jsonString
	 * @return
	 */
	public static List<Map<String, Object>> getListMap(final String jsonString) {
		if ("".equals(jsonString) || jsonString == null) {
			return null;
		} else {
			List<Map<String, Object>> list = new ArrayList<>();
			try {
				// 两种写法
				// list = JSON.parseObject(jsonString, new
				// TypeReference<List<Map<String, Object>>>(){}.getType());
				list = JSON.parseObject(jsonString,
						new TypeReference<List<Map<String, Object>>>() {
						});
			} catch (Exception e) {
				log.error("json to List<Map> failed");
				e.printStackTrace();
			}
			return list;
		}
	}

	/**
	 * 将json字符串转化为Map<String,Object>
	 *
	 * @param jsonString
	 * @return
	 */
	public static Map<String, Object> getMap(final String jsonString) {
		if ("".equals(jsonString) || jsonString == null) {
			return null;
		} else {
			Map<String, Object> map = new HashMap<>();
			try {
				map = JSON.parseObject(jsonString,
						new TypeReference<Map<String, Object>>() {
						});
			} catch (Exception e) {
				log.error("json to Map failed");
				e.printStackTrace();
			}
			return map;
		}
	}

	//过滤特定字段，同时忽略null值
	public static String toJsonWithExFilterIgnoreNull(Object object, String... props) {
		if (null == object)
			return null;
		SimplePropertyPreFilter sp = new SimplePropertyPreFilter();
		for (String pro : props
				) {
			sp.getExcludes().add(pro);
		}
		return JSON.toJSONString(object, sp, Features);
	}

	//过滤特定字段，同时输出null值
	public static String toJsonWithExFilter(Object object, String... props) {
		if (null == object)
			return null;
		SimplePropertyPreFilter sp = new SimplePropertyPreFilter();
		for (String pro : props
				) {
			sp.getExcludes().add(pro);
		}
		return JSON.toJSONString(object, sp, WriteNullValueFeatures);
	}


	//只保留特定字段，同时忽略null值
	public static String toJsonWithInFilterIgnoreNull(Object object, String... props) {
		if (null == object)
			return null;
		SimplePropertyPreFilter sp = new SimplePropertyPreFilter(props);
		return JSON.toJSONString(object, sp, Features);
	}


	//只保留特定字段，同时输出null值
	public static String toJsonWithInFilter(Object object, String... props) {
		if (null == object)
			return null;
		SimplePropertyPreFilter sp = new SimplePropertyPreFilter(props);
		return JSON.toJSONString(object, sp, WriteNullValueFeatures);
	}
}
