package cn.framework.common;


import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author zhangjinci
 * @version 2016/7/15 11:23
 * @function 动态类加载器
 */
public class DynamicClassLoader extends URLClassLoader {

    public DynamicClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public DynamicClassLoader(URL[] urls) {
        super(urls);
    }

}
