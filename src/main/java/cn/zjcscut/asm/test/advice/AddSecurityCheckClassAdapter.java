//package cn.zjcscut.asm.test.advice;
//
//import org.objectweb.asm.ClassAdapter;
//import org.objectweb.asm.ClassVisitor;
//import org.objectweb.asm.MethodVisitor;
//
///**
// * @author zhangjinci
// * @version 2016/7/5 11:22
// */
//public class AddSecurityCheckClassAdapter  extends ClassAdapter {
//
//
//    private String enhancedSuperName = null;
//    public AddSecurityCheckClassAdapter(ClassVisitor cv) {
//        //Responsechain 的下一个 ClassVisitor，这里我们将传入 ClassWriter，
//        // 负责改写后代码的输出
//        super(cv);
//    }
//
//    @Override
//    public void visit(final int version, final int access, final String name,
//                      final String signature, final String superName,
//                      final String[] interfaces) {
//        String enhancedName = name + "$EnhancedByASM";  // 改变类命名
//        enhancedSuperName = name; // 改变父类，这里是”Account”
//        super.visit(version, access, enhancedName, signature,
//                enhancedSuperName, interfaces);
//    }
//
//    @Override
//    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
//        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
//        MethodVisitor wrappedMv = mv;
//        if (mv != null) {
//            if (name.equals("operation")) {
//                wrappedMv = new AddSecurityCheckMethodAdapter(mv);
//                System.out.println("op-->" + wrappedMv);
//            } else if (name.equals("<init>")) {
//                wrappedMv = new ChangeToChildConstructorMethodAdapter(mv, enhancedSuperName);
//                System.out.println("init---》" + wrappedMv);
//            }
//        }
//        return wrappedMv;
//    }
//}
