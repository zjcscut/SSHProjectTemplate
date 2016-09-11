package cn.util.http;

import org.apache.http.client.config.RequestConfig;

/**
 * @author zjc
 * @version 16-9-12 上午12:23
 * @description HttpClient工具类
 */
public class HttpUtils {

	private static final HttpUtils single = new HttpUtils(); //单例

	private HttpUtils() {
	}

	public HttpUtils getInstance() {
		return single;
	}

	private Integer socketTimeOut = 15000; //默认socket超时时间,单位:毫秒
	private Integer connectTimeOut = 15000; //默认connection超时时间,单位:毫秒
	private Integer connectRequestTimeOut = 15000; //默认connectRequest超时时间,单位:毫秒
	private String charSet = "UTF-8";  //默认编码
	private String emptyResult = "";  //默认空Response返回值


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

	//构建基础请求参数
	private RequestConfig buildRequestConfig = RequestConfig.custom()
			.setSocketTimeout(socketTimeOut)
			.setConnectTimeout(connectTimeOut)
			.setConnectionRequestTimeout(connectRequestTimeOut)
			.build();
}
