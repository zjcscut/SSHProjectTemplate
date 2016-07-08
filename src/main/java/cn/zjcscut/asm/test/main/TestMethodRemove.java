package cn.zjcscut.asm.test.main;

import aj.org.objectweb.asm.ClassReader;
import aj.org.objectweb.asm.ClassVisitor;
import aj.org.objectweb.asm.ClassWriter;
import cn.zjcscut.asm.test.adapter.ChangeVersionAdapter;
import cn.zjcscut.asm.test.adapter.RemoveMethodAdapter;
import com.sun.tools.javac.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author zhangjinci
 * @version 2016/7/5 19:50
 */
public class TestMethodRemove {

    public static void main(String[] args) throws Exception {
        String outputPath = "D:\\Develop\\Projects\\SSHProjectTemplate\\target\\classes\\cn\\zjcscut\\asm\\test\\entity\\";
        ClassReader classReader = new ClassReader(new FileInputStream(new File(outputPath + "Account.class")));
        ClassWriter classWriter = new ClassWriter(classReader, 0);
        RemoveMethodAdapter cc = new RemoveMethodAdapter(classWriter);
        cc.setmName("operation");
        cc.setmDesc("()V");
        classReader.accept(cc, 0);
        byte[] b2 = classWriter.toByteArray();
        File file = new File(outputPath + "Account.class");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(b2);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
