package cn.ppfix.controller;

import cn.ppfix.service.AreaService;
import cn.ppfix.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zjc
 * @version 2016/5/16 22:10
 */
@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "area.html", method = RequestMethod.GET)
    @ResponseBody
    public String queryArea(@RequestParam(value = "name") String name) {
        return JsonUtil.toJson(areaService.findAreaByName(name));
    }

}
