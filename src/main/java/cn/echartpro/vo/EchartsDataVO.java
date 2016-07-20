package cn.echartpro.vo;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zjc
 * @version 2016/7/17 11:21
 * @function
 */
public class EchartsDataVO extends JSONObject {

	private String name;

	private Integer num;

	public EchartsDataVO() {

	}

	public EchartsDataVO(String name, Integer num) {
		this.put("name", name);
		this.put("value", num);
	}

	public String getName() {
		return this.getString("name");
	}

	public void setName(String name) {
		this.put("name", name);
	}

	public Integer getNum() {
		return this.getInteger("value");
	}

	public void setNum(Integer num) {
		this.put("value", num);
	}
}
