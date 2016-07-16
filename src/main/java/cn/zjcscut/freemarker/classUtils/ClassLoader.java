package cn.zjcscut.freemarker.classUtils;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author zhangjinci
 * @version 2016/7/12 17:33
 * @function
 */
public class ClassLoader extends URLClassLoader {

	public ClassLoader(URL[] urls, java.lang.ClassLoader parent) {
		super(urls, parent);
	}

	@SuppressWarnings("ConstantConditions")
	public static String getClassPath() {
		return ClassLoader.class.getClassLoader().getResource("").getPath();
	}

	@SuppressWarnings("ConstantConditions")
	public static String getClassPath(Class<?> clazz) {
		return clazz.getClassLoader().getResource("").getPath();
	}

	//获取工作目录路径
	public static String getUserDir() {
		return System.getProperty("user.dir");
	}
}
