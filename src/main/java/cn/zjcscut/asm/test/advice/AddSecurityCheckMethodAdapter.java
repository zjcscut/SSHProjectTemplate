//package cn.zjcscut.asm.test.advice;
//
//
//import org.objectweb.asm.MethodAdapter;
//import org.objectweb.asm.MethodVisitor;
//import org.objectweb.asm.Opcodes;
//
///**
// * @author zhangjinci
// * @version 2016/7/5 11:27
// */
//public class AddSecurityCheckMethodAdapter extends MethodAdapter {
//
//    public AddSecurityCheckMethodAdapter(MethodVisitor mv) {
//        super(mv);
//    }
//
//    @Override
//    public void visitCode() {
//        visitMethodInsn(Opcodes.INVOKESTATIC, "SecurityChecker", "checkSecurity", "()V");
//    }
//}
