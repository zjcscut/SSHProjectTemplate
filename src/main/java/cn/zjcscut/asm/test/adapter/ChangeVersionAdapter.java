package cn.zjcscut.asm.test.adapter;

import aj.org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;


/**
 * @author zhangjinci
 * @version 2016/7/5 18:19
 */
public class ChangeVersionAdapter extends ClassVisitor{

    public static final int ASM_API_VERSION = Opcodes.ASM4;
    public static final int JDK_API_VERSION = Opcodes.V1_7;
    public ChangeVersionAdapter(ClassVisitor classVisitor) {
        super(ASM_API_VERSION, classVisitor);
    }

    @Override
    public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
        super.visit(JDK_API_VERSION, i1, s, s1, s2, strings);
    }
}
