/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.util.http.origin;


import cn.util.json.FastJsonUtils;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/9/14 9:57
 * @function 构造Http请求, 保存某次请求所有需要的参数
 */
public class HttpRequest {

    private String url;
    private METHOD method;
    private Headers headers;
    private Map<String, Object> params;
    private URL nativeUrl;  //根据参数构造出来的url

    public String getUrl() {
        return url;
    }

    public HttpRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public METHOD getMethod() {
        return method;
    }

    public HttpRequest setMethod(METHOD method) {
        this.method = method;
        return this;
    }

    public Headers getHeaders() {
        return headers;
    }

    public HttpRequest setHeaders(Headers headers) {
        this.headers = headers;
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public HttpRequest setParams(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    public enum METHOD {
        GET, POST, PUT, DELETE, OPTIONS, TRACE, CONNECT, HEAD
    }

    public static HttpRequest get(String url) {
        return build(url, METHOD.GET, new HashMap<String, Object>());
    }

    public static HttpRequest get(String url, Headers headers) {
        return build(url, METHOD.GET, new HashMap<String, Object>(), headers);
    }

    public static HttpRequest post(String url) {
        return build(url, METHOD.POST, new HashMap<String, Object>());
    }

    public static HttpRequest post(String url, Headers headers) {
        return build(url, METHOD.POST, new HashMap<String, Object>(), headers);
    }

    public static HttpRequest build(String url, METHOD method, String jsonStrParam) {
        return build(url, method, FastJsonUtils.toMap(jsonStrParam));
    }

    public static HttpRequest build(String url, METHOD method, String jsonStrParam, Headers headers) {
       return build(url, method, FastJsonUtils.toMap(jsonStrParam), headers);
    }

    public static HttpRequest build(String url, METHOD method) {
        return build(url, method, new HashMap<String, Object>());
    }

    public static HttpRequest build(String url, METHOD method, Map<String, Object> params) {
        return build(url, method, params, Headers.build());
    }

    public static HttpRequest build(String url, METHOD method, Map<String, Object> params, Headers headers) {
        return new HttpRequest().setUrl(url).setMethod(method).setParams(params).setHeaders(headers);
    }
}
