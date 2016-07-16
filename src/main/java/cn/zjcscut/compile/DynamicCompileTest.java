package cn.zjcscut.compile;

/**
 * @author zhangjinci
 * @version 2016/7/13 17:04
 * @function
 */


import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class DynamicCompileTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
   /*
     * 编译内存中的java代码
     */
        // 将代码写入内存中
        StringWriter writer = new StringWriter();// 内存字符串输出流
        PrintWriter out = new PrintWriter(writer);
        out.println("package com.flyoung.hello;\n");
		out.print("import java.text.SimpleDateFormat;\n");
		out.print("import java.util.Date;\n");
        out.println("public class Hello{");
        out.println("public static void main(String[] args){");
        out.println("System.out.println(\"Hello World! Today is \" + new SimpleDateFormat(\"yyyy-MM-dd\").format(new Date()));");
        out.println("}");
        out.println("}");
        out.flush();
        out.close();

//        Writer errOut = new FileWriter("D:\\compile\\out\\err.txt");  //设置编译错误信息输出文件

        // 开始编译
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();

        JavaFileObject fileObject = new JavaStringObject("Hello", writer.toString());   //这里第二个参数其实可以直接写入字符串


        CompilationTask task = javaCompiler.getTask(null, null, null,
                Arrays.asList("-d", "./lib"), null, Arrays.asList(fileObject));  //-d对应后面的"./lib"为输出目录, 最后一个参数Arrays.asList(fileObject)为文件内容
        boolean success = task.call();
        if (!success) {
            System.out.println("编译失败!");
        } else {
            System.out.println("编译成功！");
            //利用反射调用其中的main()方法
            // Class class1=Class.forName("com.flyoung.hello.Hello");
            //ClassLoader是自动去从当前工作目录下的classpath路径下去找 也就是bin目录下
            //Class class1=ClassLoader.getSystemClassLoader().loadClass("com.flyoung.hello.Hello");

            //利用URLClassLoader去实例化一个Class类  类文件可以放在任意位置，这样就很方便了
            URL[] urls = new URL[]{new URL("file://" + System.getProperty("user.dir") + "/lib/")};  //url必须给定protocol
            System.out.println("----> " + urls[0].toString());
            URLClassLoader classLoader = new URLClassLoader(urls);
            Class class1 = classLoader.loadClass("com.flyoung.hello.Hello");
            Method method = class1.getDeclaredMethod("main", String[].class);
            String[] args1 = {null};

            ByteArrayOutputStream bao = new ByteArrayOutputStream(1024);
            PrintStream cacheStream = new PrintStream(bao);
//			PrintStream oldStream = System.out;



            method.invoke(class1.newInstance(), args1);
			System.setOut(cacheStream);
			String message = cacheStream.toString();

			message = "----------------" + message + "------------";
//			System.setOut(oldStream);
			System.out.println(message);
			bao.close();
			cacheStream.close();
//			oldStream.close();
		}
    }
}