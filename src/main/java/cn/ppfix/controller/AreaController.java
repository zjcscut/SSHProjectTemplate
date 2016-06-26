package cn.ppfix.controller;

import cn.ppfix.common.annotation.JsonResponse;
import cn.ppfix.entity.Area;
import cn.ppfix.entity.District;
import cn.ppfix.service.AreaService;
import cn.ppfix.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zjc
 * @version 2016/5/16 22:10
 */
@Controller
@JsonResponse(ignoreNull = false, includeFilter = {"id", "name"}, exculdeFilter = {"districts"})
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "area.html", method = RequestMethod.GET)
    @ResponseBody
    public String queryArea() {
        return JsonUtil.toJson(areaService.findArea());
    }

    @RequestMapping(value = "area/update.html")
    @ResponseBody
    public String updateArea(@RequestParam(value = "id") Integer id) {
        areaService.updateArea(id);
        return JsonUtil.toJson(areaService.findById(id));
    }

    @RequestMapping(value = "all/area.html")
    public ModelAndView findAllArea(ModelAndView m) {
        m.setViewName("index");
        m.addObject("ok",true);
        m.addObject("areas", areaService.selectAllArea());
        return m;
    }

	@RequestMapping(value = "test/json.html")
	@ResponseBody
	@JsonResponse(ignoreNull = false, includeFilter = {"id", "name"}, exculdeFilter = {"districts"})
	public Object testJsonAdaptor() {
		Area area = new Area();
//		area.setId(1);
//		area.setName("上海");
//		area.setPid(11111);
//		districts.add(new District("广州"));
		List<Area> list = new ArrayList<>();
//		Area area1 = new Area();
//		area1.setId(12);
//		area1.setName("北京");
//		list.add(area);
//		list.add(area1);
		return list;
	}

}
