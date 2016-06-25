package cn.ppfix.cglib.bean;

/**
 * @author zhangjinci
 * @version 2016/6/17 8:59
 */
public class Chinese {

    public String sayHello(String name) {
        return "正在执行sayHello方法,name为-->" + name;
    }

    public void eat(String name) {
        System.out.println("我正在吃-->" + name);
    }
}
