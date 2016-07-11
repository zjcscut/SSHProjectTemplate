package cn.zjcscut.asm.test.api;

import aj.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

/**
 * @author zhangjinci
 * @version 2016/7/5 14:47
 */
public class CreateClass extends ClassLoader {
    private final static String outputPath = "D:\\Develop\\Projects\\SSHProjectTemplate\\target\\classes\\cn\\zjcscut\\asm\\test\\result\\";

    private String realPath = this.getClass().getResource("").getPath();

    public static void main(String[] args) throws Exception {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "cn/zjcscut/asm/test/result/Comparable", null, "java/lang/Object",
                null);
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
                null, new Integer(1)).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();
        byte[] b = cw.toByteArray();
        //文件名必须是真实路径下的真实文件名,文件名称必须和类的名称一致
        File file = new File(outputPath + "Comparable" + ".class");
        FileOutputStream out = new FileOutputStream(file);
        out.write(b);
        out.close();

        CreateClass createClass = new CreateClass();

        //这个类名必须写全类名
        Class<?> clazz = createClass.defineClass("cn.zjcscut.asm.test.result.Comparable", b, 0, b.length);
        String s = clazz.getName();
        System.out.println("class名--> " + s);
        String methodName = clazz.getMethods()[0].getName();
        System.out.println("第一个方法名: " + methodName);
        //noinspection ConstantConditions
        String path = createClass.getResource("").getPath();
        System.out.println("项目的根路径-- > " + path);
    }
}
