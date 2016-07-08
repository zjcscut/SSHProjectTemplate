package cn.zjcscut.asm.test.adapter;

import aj.org.objectweb.asm.ClassVisitor;
import aj.org.objectweb.asm.MethodVisitor;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM4;

/**
 * @author zhangjinci
 * @version 2016/7/5 19:46
 */
public class RemoveMethodAdapter extends ClassVisitor{

    private String mName;
    private String mDesc;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public RemoveMethodAdapter(ClassVisitor classVisitor) {
        super(ASM4, classVisitor);
    }

    //access为修饰符的int类型,name为方法名,desc为方法签名,signature为泛型信息
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
//        System.out.println("desc-- > " + desc);
       if (name.equals(mName) && desc.equals(mDesc)){
           //返回null,不要委托下一个访问器 -->这样就能移除方法
           return null;
       }
        return cv.visitMethod(access, name, desc, signature, exceptions);
    }
}
