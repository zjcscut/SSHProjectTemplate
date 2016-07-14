package cn.zjcscut.freemarker.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author zjc
 * @version 2016/7/12 23:30
 * @function
 */
public class ConfigUtils{

	private final static Logger log = LogManager.getLogger(ConfigUtils.class);

	public String savePath = System.getProperty("user.dir"); //获取当前工作目录

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	//加载json配置文件转化为字符串
	public String loadConfigFileToString() throws Exception{
        return null;
	}


}
