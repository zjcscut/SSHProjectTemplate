/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.util.http.origin;

import cn.util.json.FastJsonUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/9/14 9:58
 * @function
 */
public class Headers {

    private Map<String, String> items;

    private Headers() {
        items = new HashMap<>();
    }

    public String get(String key) {
        return items.get(key);
    }

    public String get(String key, String defaultValue) {
        if (get(key) == null) {
            return defaultValue;
        }
        return get(key);
    }

    public Integer get(String key, Integer defaultValue) {
        if (get(key) == null) {
            return defaultValue;
        }
        return Integer.valueOf(get(key));
    }

    public Headers set(String key, String value) {
        if (null != key) {
            items.put(key, value);
        }
        return this;
    }

    public Headers addAll(Map<String, String> source) {
        items.putAll(source);
        return this;
    }

    public Headers remove(String key) {
        items.remove(key);
        return this;
    }

    public Headers clear(String key) {
        items.clear();
        return this;
    }

    public static Headers build(String source) {
        return new Headers().addAll(FastJsonUtils.toMapS(source));
    }

    public static Headers build(Map<String, String> source) {
        return new Headers().addAll(source);
    }

    public static Headers build() {
        Headers headers = new Headers();
        headers.set("User-Agent", "Native.Http");
        headers.set("Accept-Encoding", "gzip,deflate");
        headers.set("Accept", "text/xml,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        headers.set("Accept-Language", "en-US,en,zh,zh-CN");
        headers.set("Accept-Charset", "ISO-8859-1,*,utf-8");
        headers.set("Connection", "keep-alive");
        headers.set("Cache-Control", "max-age=0");
        return headers;
    }

}
