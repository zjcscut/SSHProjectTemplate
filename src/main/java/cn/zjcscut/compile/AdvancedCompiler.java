package cn.zjcscut.compile;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author zhangjinci
 * @version 2016/7/13 16:12
 * @function
 */
public class AdvancedCompiler {

    @SuppressWarnings({"ArraysAsListWithZeroOrOneArgument", "ResultOfMethodCallIgnored"})
    public static void main(String[] args) throws Exception {
        File dir=new File(System.getProperty("user.dir")+"/temp");//临时目录
        //如果/temp目录不存在创建temp目录
        if(!dir.exists()){
            dir.mkdir();
        }

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler(); //获取系统编译器
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, Locale.getDefault(), Charset.forName("UTF-8"));
        JavaFileObject file = constructTestor();
        Iterable<? extends JavaFileObject> files = Arrays.asList(file);
        File filepath = new File("D:/compile/out/err.txt");
        if (!filepath.exists()) {
            filepath.getParentFile().mkdirs();
        }
        Writer out = new FileWriter(filepath);  //控制台错误信息输出目录
        JavaCompiler.CompilationTask task = compiler.getTask(
                out, fileManager, null, null, null, files
        );
        Boolean result = task.call();
        if (result) {
            System.out.println("Succeeded");
        }

    }

    private static SimpleJavaFileObject constructTestor() {
        StringBuilder contents = new StringBuilder(
                "package cn.zjcscut.compile;\n" +
                        "\n" +
                        "public class Target {\n" +
                        "\n" +
                        "    public void doSomething(){\n" +
                        "        // 这个构造函数被标记为deprecated, 编译时会向控制台输出输出信息。\n" +
                        "        System.out.println(\"犀利到世界甘 .......\");\n" +
                        "    }\n" +
                        "}");
        StringObject so = null;
        try {
            so = new StringObject("cn.zjcscut.compile", contents.toString());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return so;
    }

}

