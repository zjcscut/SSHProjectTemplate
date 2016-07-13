package cn.zjcscut.compile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author zhangjinci
 * @version 2016/7/13 15:56
 * @function
 */
public class Compiler {

    //动态编译，输出到.class到当前目录
    public static void main(String[] args) throws Exception {
        String path = "D:\\Develop\\Projects\\SSHProjectTemplate\\src\\main\\java\\cn\\zjcscut\\compile";
        String fileName = path + File.separator + "Target.java";
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();  // 获取系统编译器
        FileOutputStream err = new FileOutputStream("err.txt");
        int result = compiler.run(null,null,err,fileName);
        if(result == 0){
            System.out.println("Done");
        } else {
            System.out.println("Fail");
        }
    }
}
