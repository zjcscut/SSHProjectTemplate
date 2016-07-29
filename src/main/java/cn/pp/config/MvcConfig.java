//package cn.ppfix.config;
//
//import cn.zjcscut.aop.anno.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
///**
// * @author zjc
// * @version 2016/7/19 23:28
// * @function 编程式配置Spring，相当于dispatcher-servlet.xml
// */
//@Configuration
////相当于context:component-scan
//@ComponentScan(basePackages = {"cn.zjcscut", "cn.ppfix", "cn.zjc"}, useDefaultFilters = false,
//		includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
//				value = {Controller.class})
//		})
//public class MvcConfig extends WebMvcConfigurationSupport {
//
//	@Bean
//	public ViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INFZ/jsp/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
//}
