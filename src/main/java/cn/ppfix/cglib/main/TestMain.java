package cn.ppfix.cglib.main;

import cn.ppfix.cglib.bean.Chinese;
import cn.ppfix.cglib.proxy.ChineseProxyFactory;

/**
 * @author zhangjinci
 * @version 2016/6/17 9:04
 */
public class TestMain {

    public static void main(String[] args) {
        Chinese chinese = ChineseProxyFactory.getInstance();
        System.out.println(chinese.sayHello("初音未来"));
        chinese.eat("苹果");
        System.out.println(chinese.getClass());
    }
}
