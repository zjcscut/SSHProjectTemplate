package cn.zjcscut.freemarker.config;

import freemarker.cache.StringTemplateLoader;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author zjc
 * @version 2016/7/11 23:02
 * @function
 */
public class FreeMarkerConfig {

	//	private static final StringTemplateLoader loader = new StringTemplateLoader();
	private static final String DEFAULT_CHARSET = "UTF-8";

	private static final Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);

	static {
		cfg.setEncoding(Locale.getDefault(), DEFAULT_CHARSET);
		try {
			cfg.setClassLoaderForTemplateLoading(FreeMarkerConfig.class.getClassLoader(), "template");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		cfg.setTemplateLoader(loader);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}

	public static void main(String[] args) throws Exception {
		Map<String, Object> root = new HashMap<>();
		root.put("user", "zjcscut");
		Map<String, Object> last = new HashMap<>();
		root.put("latestProduct", last);
		last.put("url", "www.baidu.com");
		last.put("name", "犀利世界");
		Template temp = cfg.getTemplate("test.ftl");

		String path = "I:/freemarker/out/test.html";
		new File("I:/freemarker/out").getParentFile().mkdirs();
		Writer out = new OutputStreamWriter(new FileOutputStream(path));
		Environment environment = temp.createProcessingEnvironment(root, out);
		environment.setOutputEncoding(DEFAULT_CHARSET);  //设置输出编码格式
		environment.process();
		out.close();
	}
}
