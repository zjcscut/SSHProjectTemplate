package cn.ppfix.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * jsp标签：具有防盗链功能，如果url来源不带有site域名，会强制重定向到page
 * @author zhangjinci
 * @version 2016/6/23 14:26
 */
public class RefererTag extends SimpleTagSupport {

    //域名
    private String site;
    //需要跳转到的页面
    private String page;

    public void setPage(String page) {
        this.page = page;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) this.getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String referer = request.getHeader("Referer");
        if (null == referer || !referer.startsWith(site)) {
            HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
            String webRoot = request.getContextPath();
            if (page.startsWith(webRoot)) {
                response.sendRedirect(page);
            } else {
                response.sendRedirect(webRoot + page);
            }
        }
        throw new SkipPageException(); //跳出，防止后面的页面内容渲染
    }
}
