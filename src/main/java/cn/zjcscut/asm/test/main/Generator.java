//package cn.zjcscut.asm.test.main;
//
//import cn.zjcscut.asm.test.advice.AddSecurityCheckClassAdapter;
//import cn.zjcscut.asm.test.entity.Account;
//import org.objectweb.asm.ClassAdapter;
//import org.objectweb.asm.ClassReader;
//import org.objectweb.asm.ClassWriter;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
///**
// * @author zhangjinci
// * @version 2016/7/5 11:29
// */
//public class Generator {
//
//    public static void main(String[] args) throws Exception{
//        ClassReader cr = new ClassReader("cn.zjcscut.asm.test.entity.Account");
//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
//        ClassAdapter ca = new AddSecurityCheckClassAdapter(cw);
//        cr.accept(ca,ClassReader.SKIP_DEBUG);
//        byte[] data = cw.toByteArray();
//        String outputPath = "D:\\Develop\\Projects\\SSHProjectTemplate\\target\\classes\\cn\\zjcscut\\asm\\test\\entity\\";
//        File file = new File(outputPath + "Account.class");
//        FileOutputStream fout = new FileOutputStream(file);
//        fout.write(data);
//        fout.close();
//
//        Thread.sleep(2000);
//        Account account = new Account();
//        account.operation();
//    }
//}
