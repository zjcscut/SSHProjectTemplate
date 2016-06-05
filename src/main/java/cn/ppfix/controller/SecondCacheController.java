package cn.ppfix.controller;

import cn.ppfix.service.AreaService;
import cn.ppfix.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zjc
 * @version 2016/6/3 2:14
 */
@Controller
public class SecondCacheController {

	@Autowired
	private AreaService areaService;

	@RequestMapping("second.html")
	@ResponseBody
	public String getArea(@RequestParam(value = "id")Integer id) {
		return JsonUtil.toJson(areaService.getFromSecondCache(id));
	}

}
