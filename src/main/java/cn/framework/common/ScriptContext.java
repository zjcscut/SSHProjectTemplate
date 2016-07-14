package cn.framework.common;

/**
 * @author zjc
 * @version 2016/7/14 0:04
 * @function Script上下文
 */
public class ScriptContext {

	private String id;
	private String md5;

	public ScriptContext(String id, String md5) {
		this.id = id;
		this.md5 = md5;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}
}
