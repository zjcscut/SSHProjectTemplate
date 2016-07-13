package cn.zjcscut.compile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author zhangjinci
 * @version 2016/7/13 16:48
 * @function
 */
public class JavacTest {

    public JavacTest() {

    }

    @SuppressWarnings("unchecked")
    public static void eval(String str) {
        System.out.println(System.getProperty("user.dir"));//当前工作目录
        String s = "public class Temp{";
        s += "\r\n" + "      public static String call(String ss){      ";
        s += "\r\n" + "            System.out.println(\"" + str + "\");  ";
        s += "\r\n" + "            return \"return_str\"; ";
        s += "\r\n" + "      }";
        s += "\r\n" + "}";
        try {
            File file = new File("Temp.java");
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            //pw.println(s);
            pw.write(s);
            pw.close();

            //动态编译
            JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
            int status = javac.run(null, null, null, "-d", System.getProperty("user.dir"), "Temp.java");
            if (status != 0) {
                System.out.println("没有编译成功！");
            }

            //动态执行
            Class cls = Class.forName("Temp");//返回与带有给定字符串名的类 或接口相关联的 Class 对象。
            Method method = cls.getDeclaredMethod("call", String.class);//返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法
            String result = (String) method.invoke(null, str);//静态方法第一个参数可为null,第二个参数为实际传参
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JavacTest javacTest = new JavacTest();
        javacTest.eval("Hello zjc");
    }
}
