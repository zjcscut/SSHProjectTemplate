package cn.zjcscut.asm.test.adapter;

import aj.org.objectweb.asm.ClassReader;
import aj.org.objectweb.asm.ClassVisitor;
import aj.org.objectweb.asm.ClassWriter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @author zhangjinci
 * @version 2016/7/5 18:22
 */
public class AdapterTest extends ClassLoader {
    private String realPath = this.getClass().getResource("").getPath();
    private final static String outputPath = "D:\\Develop\\Projects\\SSHProjectTemplate\\target\\classes\\cn\\zjcscut\\asm\\test\\result\\";


    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream(outputPath + "Comparable.class");
        byte[] b1 = new byte[4096];
        int len = 0;
        if ((len = in.read(b1)) != -1) {
            System.out.println("读取到的内容为--> " + new String(b1, 0, len));
        }

        ClassReader classReader = new ClassReader(b1);

        ClassWriter classWriter = new ClassWriter(classReader,0);

        ChangeVersionAdapter ca = new ChangeVersionAdapter(classWriter);

        //上边几句是进行了classReader和classWriter之间的转换,
        // ChangeVersionAdapter此适配器没有调用任何转换方法，可以提高效率
        classReader.accept(ca,0);
        byte[] b2 = classWriter.toByteArray();

    }
    //如果要转换所有的类要把转换放在ClassFileTransformer内部
    public static void premain(String agentArgs, Instrumentation inst){
        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                                    ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                ClassReader classReader = new ClassReader(classfileBuffer);
                ClassWriter cw = new ClassWriter(classReader,0);
                ClassVisitor cv = new ChangeVersionAdapter(cw);
                classReader.accept(cv,0);
                return cw.toByteArray();
            }
        });

    }
}
