package cn.ppfix.controller;

import cn.ppfix.entity.Log;
import cn.ppfix.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zjc
 * @version 2016/6/2 20:36
 */
@Controller
public class CacheController {


	@Autowired
	private CacheService cacheService;

	@RequestMapping("insert.html")
	@ResponseBody
	public Boolean insertTest(Log log) {
		return cacheService.insertLog(log) > 0;
	}

	@RequestMapping("test1.html")
	public ModelAndView Test1(ModelAndView modelAndView) {
        modelAndView.addObject("num",cacheService.count());
		modelAndView.setViewName("pageEhcache");
		return modelAndView;
	}


}
