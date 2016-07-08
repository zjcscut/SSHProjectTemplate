package cn.zjcscut.asm.test.api;

import aj.org.objectweb.asm.ClassWriter;

/**
 * @author zhangjinci
 * @version 2016/7/5 14:58
 */
public class MyClassLoader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name.endsWith("_Stub")) {
            ClassWriter cw = new ClassWriter(0);
            byte[] b = cw.toByteArray();
            return defineClass(name, b, 0, b.length);
        }
        return super.findClass(name);
    }
}
