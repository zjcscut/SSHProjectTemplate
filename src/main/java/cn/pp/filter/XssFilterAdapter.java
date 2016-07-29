package cn.pp.filter;

import cn.pp.xss.XssHttpServletRequestWrapper;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangjinci
 * @version 2016/6/23 16:36
 */
public class XssFilterAdapter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(new XssHttpServletRequestWrapper(request), response, handler);
    }
}
