package cn.ppfix.cglib.proxy;

import cn.ppfix.cglib.advice.AroundAdvice;
import cn.ppfix.cglib.bean.Chinese;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author zhangjinci
 * @version 2016/6/17 8:57
 */
//代理的工厂类
public class ChineseProxyFactory {

	public static Chinese getInstance() {
		Enhancer enhancer = new Enhancer();
		//设置要代理的目标类
		enhancer.setSuperclass(Chinese.class);
		//设置要代理的拦截器
		enhancer.setCallback(new AroundAdvice());
		return (Chinese) enhancer.create();
	}

}
