//package cn.ppfix.config;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.*;
//import java.util.EnumSet;
//
///**
// * @author zjc
// * @version 2016/7/19 23:32
// * @function 相当于注册Web.xml中的相应组件
// */
//public class WebInitializer implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//		//1.注册配置文件
//		rootContext.register(AppConfig.class);
//		servletContext.addListener(new ContextLoaderListener(rootContext));
//
//		//2.SpringMVC上下文
//		AnnotationConfigWebApplicationContext springMvcContext = new AnnotationConfigWebApplicationContext();
//		springMvcContext.register(MvcConfig.class);
//
//		//3.DispartcherServlet
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(springMvcContext);
//		ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
//		dynamic.setLoadOnStartup(1);
//		dynamic.addMapping("/");  //根路径
//
//		//4.CharacterEncodingFilter
//		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//		characterEncodingFilter.setEncoding("UTF-8");
//		FilterRegistration filterRegistration = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
//		filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/");
//	}
//}
