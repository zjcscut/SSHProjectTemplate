/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.util.http.origin;


import cn.util.json.FastJsonUtils;

import java.io.InputStream;
import java.net.MalformedURLException;
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
    private Map<String, String> params;
    private URL nativeUrl;  //根据参数构造出来的url
    private String chartSet = "UTF-8";
    private InputStream inputStream;
    private byte[] data;

    public URL getUrl() {
        if (nativeUrl != null) {
            return nativeUrl;
        }
        StringBuffer buffer = new StringBuffer(url);
        if (this.isGet() && params != null && !params.isEmpty() && url != null) {
            buffer.append(url.indexOf("?") > 0 ? '&' : '?');
            buffer.append(getUrlEncodedParams());
        }
        try {
            nativeUrl = new URL(buffer.toString());
            return nativeUrl;
        } catch (Exception e) {
            throw new HttpException("url:" + buffer.toString(), e);
        }
    }

    public String getUrlEncodedParams() {
        final StringBuffer buffer = new StringBuffer();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {

            }
        }
        if (buffer.length() > 0) {
            buffer.setLength(buffer.length() - 1); //去掉最后那个'&'
        }
        return buffer.toString();
    }

    public HttpRequest setUrl(String url) {
        if (null != url && url.contains("://")) {
            this.url += "http://" + url;
        } else {
            this.url = url;
        }
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

    public Map<String, String> getParams() {
        return params;
    }

    public HttpRequest setParams(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public enum METHOD {
        GET, POST, PUT, DELETE, OPTIONS, TRACE, CONNECT, HEAD
    }

    public static HttpRequest get(String url) {
        return build(url, METHOD.GET, new HashMap<String, String>());
    }

    public static HttpRequest get(String url, Headers headers) {
        return build(url, METHOD.GET, new HashMap<String, String>(), headers);
    }

    public static HttpRequest post(String url) {
        return build(url, METHOD.POST, new HashMap<String, String>());
    }

    public static HttpRequest post(String url, Headers headers) {
        return build(url, METHOD.POST, new HashMap<String, String>(), headers);
    }

    public static HttpRequest build(String url, METHOD method, String jsonStrParam) {
        return build(url, method, FastJsonUtils.toMapS(jsonStrParam));
    }

    public static HttpRequest build(String url, METHOD method, String jsonStrParam, Headers headers) {
        return build(url, method, FastJsonUtils.toMapS(jsonStrParam), headers);
    }

    public static HttpRequest build(String url, METHOD method) {
        return build(url, method, new HashMap<String, String>());
    }

    public static HttpRequest build(String url, METHOD method, Map<String, String> params) {
        return build(url, method, params, Headers.build());
    }

    public static HttpRequest build(String url, METHOD method, Map<String, String> params, Headers headers) {
        return new HttpRequest().setUrl(url).setMethod(method).setParams(params).setHeaders(headers);
    }

    //GET, POST, PUT, DELETE, OPTIONS, TRACE, CONNECT, HEAD
    public boolean isGet() {
        return METHOD.GET == this.method;
    }

    public boolean isDelete() {
        return METHOD.DELETE == this.method;
    }

    public boolean isPost() {
        return METHOD.POST == this.method;
    }

    public boolean isPut() {
        return METHOD.PUT == this.method;
    }

    public boolean isOption() {
        return METHOD.OPTIONS == this.method;
    }

    public boolean isTrace() {
        return METHOD.TRACE == this.method;
    }

    public boolean isConnect() {
        return METHOD.CONNECT == this.method;
    }

    public boolean isHead() {
        return METHOD.HEAD == this.method;
    }
}
