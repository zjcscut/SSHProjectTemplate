package cn.ppfix.controller;

import cn.ppfix.utils.JsonUtil;
import cn.zjcscut.dao.common.RequestUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangjinci
 * @version 2016/6/23 16:42
 */
@RestController
public class XssController {

    @RequestMapping(value = "/xss/test.html")
    public String testXss(HttpServletRequest request) {
        System.out.println(JsonUtil.toJson(request.getParameterMap()));
        return "success";
    }

	@RequestMapping(value = "/test/params.html")
	public String testParams(HttpServletRequest request) {
		System.out.println(RequestUtil.params(request,"user"));
		return "success";
	}

}
