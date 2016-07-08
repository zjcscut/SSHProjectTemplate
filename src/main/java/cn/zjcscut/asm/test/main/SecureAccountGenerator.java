//package cn.zjcscut.asm.test.main;
//
//import cn.zjcscut.asm.test.advice.AddSecurityCheckClassAdapter;
//import cn.zjcscut.asm.test.entity.Account;
//import org.objectweb.asm.ClassAdapter;
//import org.objectweb.asm.ClassReader;
//import org.objectweb.asm.ClassWriter;
//
//
//import java.io.IOException;
//
///**
// * @author zhangjinci
// * @version 2016/7/5 12:02
// */
//public class SecureAccountGenerator extends ClassLoader{
//
////    private static AccountGeneratorClassLoader classLoader =
////            new AccountGeneratorClassLoader();
//
////    private static Class secureAccountClass;
//
//    public Account generateSecureAccount() throws ClassFormatError,
//            InstantiationException, IllegalAccessException, IOException {
////        if (null == secureAccountClass) {
//            ClassReader cr = new ClassReader("cn.zjcscut.asm.test.entity.Account");
//            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
//            ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
//            cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
//            byte[] data = cw.toByteArray();
////            secureAccountClass = classLoader.defineClassFromClassFile(
////                    "cn.zjcscut.asm.test.entity.Account$EnhancedByASM", data);
////        }
//        SecureAccountGenerator loader = new SecureAccountGenerator();
//        Class<?> acc = loader.defineClass("cn.zjcscut.asm.test.entity.Account$EnhancedByASM",data,0,data.length);
//        return   (Account) acc.newInstance();
//    }
//
////    private static class AccountGeneratorClassLoader extends ClassLoader {
////        public Class defineClassFromClassFile(String className,
////                                              byte[] classFile) throws ClassFormatError {
////            return defineClass(className, classFile, 0,
////                    classFile.length);
////        }
////    }
//
//}
