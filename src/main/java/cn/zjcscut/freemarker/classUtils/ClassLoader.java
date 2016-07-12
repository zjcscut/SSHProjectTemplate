package cn.zjcscut.freemarker.classUtils;

/**
 * @author zhangjinci
 * @version 2016/7/12 17:33
 * @function
 */
public class ClassLoader {

    @SuppressWarnings("ConstantConditions")
    public static String getClassPath(Class<?> clazz) {
        return clazz.getClassLoader().getResource("").getPath();
    }
}
