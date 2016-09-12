/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.util.http;

import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.*;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * @author zjc
 * @version 16-9-12 上午12:23
 * @description HttpClient工具类, 方法设计解耦
 *
 * <!--httpClient 依赖-->
 * <dependency>
 * <groupId>org.apache.httpcomponents</groupId>
 * <artifactId>httpclient</artifactId>
 * <version>4.5.2</version>
 * </dependency>
 * <dependency>
 * <groupId>org.apache.httpcomponents</groupId>
 * <artifactId>httpcore</artifactId>
 * <version>4.4.5</version>
 * </dependency>
 * <dependency>
 * <groupId>org.apache.httpcomponents</groupId>
 * <artifactId>httpmime</artifactId>
 * <version>4.5.2</version>
 * </dependency>
 * <p>
 * <p>
 * <code>demo1</code>
 * @Test public void Test() {
 * Map<String, String> params = new HashMap<>(2);
 * params.put("id", "1");
 * params.put("name", "zjc");
 * String re = HttpUtils.getInstance().setDefaultHeader("header1", "value1").doGet("http://localhost:9090/sys/hello2.html", params).getContent();
 * System.out.println("result:" + re);
 * }
 * <code>demo2</code>
 * @Test public void testUpload() {
 * Map<String, String> params = new HashMap<>(1);
 * params.put("name", "zjc");
 * List<File> files = new ArrayList<>(2);
 * files.add(new File("D://1.txt"));
 * files.add(new File("D://2.txt"));
 * String re = HttpUtils.getInstance().doMultiPost("http://localhost:9090/sys/test/push/postFile.html", null, params, files).getContent();
 * System.out.println("result==>" + re);
 * }
 */
public class HttpUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    private static final HttpUtils single = new HttpUtils(); //单例

    private HttpUtils() {
    }

    public static HttpUtils getInstance() {
        return single;
    }

    private Integer socketTimeOut = 15000; //默认socket超时时间,单位:毫秒
    private Integer connectTimeOut = 15000; //默认connection超时时间,单位:毫秒
    private Integer connectRequestTimeOut = 15000; //默认connectRequest超时时间,单位:毫秒
    private String charSet = "UTF-8";  //默认编码
    private String emptyResult = "";  //默认空Response返回值
    private Boolean isMulti = false; //是否带文件上传
    private Boolean isRetry = false; //是否重试
    private Integer maxRetryCount = 0; //最大重试次数
    private HttpHeader header; //默认请求头

    private static final String HTTP_PARAMS_PREFIX = "?";
    private static final String HTTP_PARAMS_PREFIX_SPLIT = "\\?";
    private static final String HTTP_PARAMS_SEPARATOR = "&";
    private static final String HTTP_PARAMS_EQUALS = "=";
    private static final String DEFAULT_CONTENTTYPE = "application/x-www-form-urlencoded";
    private static final String HTTP_PROTOCOL_PREFIX = "http";
    private static final String HTTPS_PROTOCOL_PREFIX = "https";


    public Integer getSocketTimeOut() {
        return socketTimeOut;
    }

    //返回工具类对象,以便构建链式条件
    public HttpUtils setSocketTimeOut(Integer socketTimeOut) {
        this.socketTimeOut = socketTimeOut;
        return this;
    }

    public Integer getConnectTimeOut() {
        return connectTimeOut;
    }

    //返回工具类对象,以便构建链式条件
    public HttpUtils setConnectTimeOut(Integer connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
        return this;
    }

    public Integer getConnectRequestTimeOut() {
        return connectRequestTimeOut;
    }

    //返回工具类对象,以便构建链式条件
    public HttpUtils setConnectRequestTimeOut(Integer connectRequestTimeOut) {
        this.connectRequestTimeOut = connectRequestTimeOut;
        return this;
    }

    public String getCharSet() {
        return charSet;
    }

    //返回工具类对象,以便构建链式条件
    public HttpUtils setCharSet(String charSet) {
        this.charSet = charSet;
        return this;
    }

    public String getEmptyResult() {
        return emptyResult;
    }

    //返回工具类对象,以便构建链式条件
    public HttpUtils setEmptyResult(String emptyResult) {
        this.emptyResult = emptyResult;
        return this;
    }

    //默认请求头
    public HttpUtils setDefaultHeader(String name, String value) {
        this.header = new HttpHeader();
        this.header.setName(name);
        this.header.setValue(value);
        return this;
    }


    public HttpHeader getDefaultHeader() {
        return this.header;
    }

    //设置是否带文件上传
    public HttpUtils setMulti() {
        this.isMulti = true;
        return this;
    }

    public Boolean isMulti() {
        return this.isMulti;
    }


    public Boolean isRetry() {
        return this.isRetry;
    }

    //设置是否重试
    public HttpUtils setRetry() {
        this.isRetry = true;
        return this;
    }

    //设置最大重试次数
    public Integer getMaxRetryCount() {
        return maxRetryCount;
    }

    public void setMaxRetryCount(Integer maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    //构建基础请求参数
    private RequestConfig buildRequestConfig = RequestConfig.custom()
            .setSocketTimeout(socketTimeOut)
            .setConnectTimeout(connectTimeOut)
            .setConnectionRequestTimeout(connectRequestTimeOut)
            .build();

    //断言请求url的格式
    private void assertUrlFormat(String url) {
        if (null == url || url.length() == 0) {
            throw new HttpException("request url could not be null");
        } else if (!url.startsWith(HTTP_PROTOCOL_PREFIX) && !url.startsWith(HTTPS_PROTOCOL_PREFIX)) {
            throw new HttpException("request url protocol must be 'HTTP' or 'HTTPS'");
        }
    }


    //发送完整参数httpGet
    public ResponseResult doGet(String url, Map<String, String> headers, Map<String, String> params) {
        return sendHttpRequest(buildHttpGetRequest(url, params), headers);
    }

    //发送不带headers参数httpGet
    public ResponseResult doGet(String url, Map<String, String> params) {
        return sendHttpRequest(buildHttpGetRequest(url, params), null);
    }

    //发送只带url的get请求
    public ResponseResult doGet(String url) {
        return sendHttpRequest(buildHttpGetRequest(url), null);
    }

    //发送完整参数httpPost
    public ResponseResult doPost(String url, Map<String, String> headers, Map<String, String> params) {
        return sendHttpRequest(buildHttpPostRequest(url, params), headers);
    }

    //发送不带headers参数httpPost
    public ResponseResult doPost(String url, Map<String, String> params) {
        return sendHttpRequest(buildHttpPostRequest(url, params), null);
    }

    //发送只带url的post请求
    public ResponseResult doPost(String url) {
        return sendHttpRequest(buildHttpPostRequest(url), null);
    }

    //发送带文件的post请求
    public ResponseResult doMultiPost(String url, Map<String, String> headers, Map<String, String> params, List<File> files) {
        this.isMulti = true;
        return sendHttpRequest(buildHttpMultiPostRequest(url, params, files), headers);
    }


    //构建post请求,请求参数为String链式:key1=value1&key2=value2
    private HttpRequestBase buildHttpPostRequest(String url) {
        assertUrlFormat(url);
        String[] postUrl = url.split(HTTP_PARAMS_PREFIX_SPLIT);
        if (postUrl.length > 2) {
            throw new HttpException("post method url params format error");
        }

        HttpPost httpPost = new HttpPost(postUrl[0]);
        try {
            //设置参数
            if (postUrl.length == 2) {
                StringEntity stringEntity = new StringEntity(postUrl[1], this.charSet);
                stringEntity.setContentType(DEFAULT_CONTENTTYPE);
                httpPost.setEntity(stringEntity);
            }
        } catch (Exception e) {
            log.error("build http post request failed:" + e.getMessage());
        }
        return httpPost;
    }

    //构建post请求
    private HttpRequestBase buildHttpPostRequest(String url, Map<String, String> params) {
        assertUrlFormat(url);
        HttpPost httpPost = new HttpPost(url);
        try {
            if (buildRequestParams(params) != null && !buildRequestParams(params).isEmpty()) {
                httpPost.setEntity(new UrlEncodedFormEntity(buildRequestParams(params), charSet));
            }
        } catch (UnsupportedEncodingException e) {
            log.error("build http post request failed:" + e.getMessage());
        }
        return httpPost;
    }

    //构建带文件post请求
    private HttpRequestBase buildHttpMultiPostRequest(String url, Map<String, String> params, List<File> files) {
        assertUrlFormat(url);
        HttpPost httpPost = new HttpPost(url);
        try {
            MultipartEntityBuilder builder = buildMultipartRequestParams(params, files);
            httpPost.setEntity(builder.build());
        } catch (Exception e) {
            log.error("build multi http post request failed:" + e.getMessage());
        }
        return httpPost;
    }

    //构建只含url的get请求
    private HttpRequestBase buildHttpGetRequest(String url) {
        assertUrlFormat(url);
        return new HttpGet(url);
    }

    //构建get请求
    private HttpRequestBase buildHttpGetRequest(String url, Map<String, String> params) {
        assertUrlFormat(url);
        StringBuilder builder = new StringBuilder(url);
        if (!url.endsWith(HTTP_PARAMS_PREFIX)) {
            builder.append(HTTP_PARAMS_PREFIX);
        }

        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.append(entry.getKey()).append(HTTP_PARAMS_EQUALS).append(entry.getValue()).append(HTTP_PARAMS_SEPARATOR);
            }
        }
        url = builder.substring(0, builder.lastIndexOf(HTTP_PARAMS_SEPARATOR));
        return new HttpGet(url);
    }


    //构建请求头参数
    private void setHttpRequestHeaders(Map<String, String> headers, HttpRequestBase requestBase) {
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestBase.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    //构建请求参数
    private List<NameValuePair> buildRequestParams(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return Collections.emptyList(); // '!= null' but  'isEmpty()' is true
        }
        List<NameValuePair> nameValuePairs = new ArrayList<>(params.size());
        for (Map.Entry<String, String> entry : params.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return nameValuePairs;
    }

    //构建带文件请求builder
    private MultipartEntityBuilder buildMultipartRequestParams(Map<String, String> params, List<File> files) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.addPart(entry.getKey(), new StringBody(entry.getValue(), ContentType.TEXT_PLAIN.withCharset(this.charSet))); //添加表单参数
            }
        }
        if (files != null && !files.isEmpty()) {
            for (File file : files) {
                builder.addPart(file.getName(), new FileBody(file)); //添加多个文件
            }
        }
        return builder;
    }

    //发送http请求,设置请求头
    private ResponseResult sendHttpRequest(HttpRequestBase requestBase, Map<String, String> headers) {
        String responseResult;
        requestBase.setConfig(buildRequestConfig);
        enableHttps(); //允许https请求
        if (headers != null && !headers.isEmpty()) {
            setHttpRequestHeaders(headers, requestBase);
        } else {
            if (!isMulti && this.header == null) {
                this.setDefaultHeader("Content-Type", DEFAULT_CONTENTTYPE);
            }
            requestBase.setHeader(this.header); //默认请求头
        }
        ResponseResult result = new ResponseResult();
        CloseableHttpClient httpClient;
        if (this.isRetry) {
            httpClient = HttpClients.custom()
                    .setRetryHandler(buildRequestRetryHandler(this.maxRetryCount))
                    .setSSLSocketFactory(socketFactory)
                    .build();
        } else {
            httpClient = HttpClients.custom()
                    .setSSLSocketFactory(socketFactory)
                    .build();
        }
        try (CloseableHttpResponse response = httpClient.execute(requestBase)) {
            result.setStatusCode(response.getStatusLine().getStatusCode());
            result.setHeaders(response.getAllHeaders());
            HttpEntity entity = response.getEntity();
            result.setContentEncoding(entity.getContentEncoding());
            result.setContentType(entity.getContentType());
            result.setContentLength(entity.getContentLength());
            responseResult = EntityUtils.toString(entity, charSet);  //这一步会关闭流
            if (responseResult == null) {
                responseResult = emptyResult;
            }
            result.setContent(responseResult);
            return result;
            //关闭了InputStream instream = entity.getContent()这个流
            //toString()方法也包含关闭流的操作,不需要重复调用
//            EntityUtils.consume(entity);
        } catch (Exception e) {
            log.error(String.format("send http %s request failed:%s", requestBase.getMethod(), e.getMessage()));
        } finally {
            try {
                if (null != httpClient) {
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error(String.format("close httpClient failed:%s", e.getMessage()));
            }
        }
        return result;
    }

    //创建重试机制处理器,尝试自动修复I/O异常
    //maxRetryCount为最大尝试次数
    private HttpRequestRetryHandler buildRequestRetryHandler(Integer maxRetryCount) {
        return new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException e, int i, HttpContext httpContext) {
                if (i > maxRetryCount) {
                    return false;
                }

                if (e instanceof InterruptedIOException) {
                    // Timeout
                    return false;
                }
                if (e instanceof UnknownHostException) {
                    // Unknown host
                    return false;
                }

                if (e instanceof SSLException) {
                    // SSL handshake exception
                    return false;
                }

                HttpClientContext clientContext = HttpClientContext.adapt(httpContext);
                HttpRequest request = clientContext.getRequest();
                return !(request instanceof HttpEntityEnclosingRequest);
            }
        };
    }


    //封装Response返回值
    public static class ResponseResult {
        private Integer statusCode; //状态码
        private String content; //返回值内容
        private Header[] headers; //所有请求头
        private Header contentType; //contentType
        private Header contentEncoding; //编码
        private Long contentLength; //内容长度

        public ResponseResult() {
        }

        public ResponseResult(Integer statusCode, String content, Header[] headers, Header contentType, Header contentEncoding, Long contentLength) {
            this.statusCode = statusCode;
            this.content = content;
            this.headers = headers;
            this.contentType = contentType;
            this.contentEncoding = contentEncoding;
            this.contentLength = contentLength;
        }

        public Integer getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(Integer statusCode) {
            this.statusCode = statusCode;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Header[] getHeaders() {
            return headers;
        }

        public void setHeaders(Header[] headers) {
            this.headers = headers;
        }

        public Header getContentType() {
            return contentType;
        }

        public void setContentType(Header contentType) {
            this.contentType = contentType;
        }

        public Header getContentEncoding() {
            return contentEncoding;
        }

        public void setContentEncoding(Header contentEncoding) {
            this.contentEncoding = contentEncoding;
        }

        public Long getContentLength() {
            return contentLength;
        }

        public void setContentLength(Long contentLength) {
            this.contentLength = contentLength;
        }

        @Override
        public String toString() {
            return "ResponseResult{" +
                    "statusCode=" + statusCode +
                    ", content='" + content + '\'' +
                    ", headers=" + Arrays.toString(headers) +
                    ", contentType=" + contentType +
                    ", contentEncoding='" + contentEncoding + '\'' +
                    ", contentLength=" + contentLength +
                    '}';
        }
    }

    //Http自定义异常
    private static class HttpException extends RuntimeException {
        public HttpException() {
            super();
        }

        public HttpException(String message) {
            super(message);
        }

        public HttpException(String message, Throwable cause) {
            super(message, cause);
        }

        public HttpException(Throwable cause) {
            super(cause);
        }
    }

    //重写请求头方法
    private static class HttpHeader implements Header, Serializable {
        private static final long serialVersionUID = -5427236326487562174L;
        private String name;
        private String value;

        public HttpHeader() {
        }

        public HttpHeader(String name, String value) {
            this.name = Args.notNull(name, "Name");
            this.value = value;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return BasicLineFormatter.INSTANCE.formatHeader(null, this).toString();
        }

        @Override
        public HeaderElement[] getElements() throws ParseException {
            return this.value != null ? BasicHeaderValueParser.parseElements(this.value, null) : new HeaderElement[0];
        }

    }


    //SSL Socket工厂
    private SSLConnectionSocketFactory socketFactory;

    //信任管理器
    private TrustManager manager = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };


    //信任所有host,不进行校验
    private void enableHttps() {
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new TrustManager[]{manager}, null);
            socketFactory = new SSLConnectionSocketFactory(context, NoopHostnameVerifier.INSTANCE);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            log.error(String.format("config https failed:%s", e.getMessage()));
        }
    }

}
