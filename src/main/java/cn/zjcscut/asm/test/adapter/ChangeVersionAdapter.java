package cn.zjcscut.asm.test.adapter;

import aj.org.objectweb.asm.ClassVisitor;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM4;
import static jdk.internal.org.objectweb.asm.Opcodes.V1_7;

/**
 * @author zhangjinci
 * @version 2016/7/5 18:19
 */
public class ChangeVersionAdapter extends ClassVisitor{

    public ChangeVersionAdapter(ClassVisitor classVisitor) {
        super(ASM4, classVisitor);
    }

    @Override
    public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
        super.visit(V1_7, i1, s, s1, s2, strings);
    }
}
