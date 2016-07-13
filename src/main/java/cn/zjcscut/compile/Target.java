package cn.zjcscut.compile;

public class Target {

    public void doSomething(){
        // 这个构造函数被标记为deprecated, 编译时会向控制台输出输出信息。
        System.out.println("Doing .......");
    }
}
