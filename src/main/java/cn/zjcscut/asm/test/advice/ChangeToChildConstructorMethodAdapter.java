//package cn.zjcscut.asm.test.advice;
//
//
//import org.objectweb.asm.MethodAdapter;
//import org.objectweb.asm.MethodVisitor;
//import org.objectweb.asm.Opcodes;
//
///**
// * @author zhangjinci
// * @version 2016/7/5 11:58
// */
//public class ChangeToChildConstructorMethodAdapter extends MethodAdapter {
//
//    private String superClassName;
//
//    public ChangeToChildConstructorMethodAdapter(MethodVisitor mv, String superClassName) {
//        super(mv);
//        this.superClassName = superClassName;
//    }
//
//    @Override
//    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
//        // 调用父类的构造函数时
//        if (opcode == Opcodes.INVOKESPECIAL && name.equals("<init>")) {
//            owner = superClassName;
//        }
//        super.visitMethodInsn(opcode, owner, name, desc);// 改写父类为 superClassName
//    }
//}
