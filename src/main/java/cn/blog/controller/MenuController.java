package cn.blog.controller;

import cn.blog.service.MenuService;
import cn.pp.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author zjc
 * @version 2016/7/30 23:19
 * @description
 */
@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;


	@RequestMapping(value = "/main/menu.html", method = RequestMethod.GET)
	public ModelAndView getMainMenu(ModelAndView mav) {
		mav.addObject("mainMenus", menuService.getMainMenus());
		mav.setViewName("theme-index");
		return mav;
	}

	@RequestMapping(value = "/menu/item/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String getMenuItems(@PathVariable(value = "id") Integer id) {
		return JsonUtil.toJson(menuService.getMenuItems(id));
	}

}
