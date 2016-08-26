package cn.pp.controller;

import cn.pp.common.annotation.JsonResponse;
import cn.pp.entity.Area;
import cn.pp.service.AreaService;
import cn.pp.utils.JsonUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * @author zjc
 * @version 2016/5/16 22:10
 */
@Controller
//@JsonResponse(ignoreNull = false, exculdeFilter = "id")
@RequestMapping("sys/")
public class AreaController {

    @RequestMapping("index")
    public String hellos() {
        return "index";
    }

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
        m.setViewName("index");  //这个是jsp文件的名称
        m.addObject("ok", true); //页面返回参数，key为"ok"
        m.addObject("areas", areaService.selectAllArea()); //页面返回参数，key为"areas"
        return m;
    }

    @RequestMapping(value = "test/json.html")
    @ResponseBody
//	@JsonResponse(ignoreNull = false, includeFilter = {"id", "name"}, exculdeFilter = {"districts"})
    public Object testJsonAdaptor() {
        Area area = new Area();
        area.setId(1);
        area.setName("上海");
        area.setPid(11111);
//		districts.add(new District("广州"));
        List<Area> list = new ArrayList<>();
        Area area1 = new Area();
        area1.setId(12);
        area1.setName("北京");
        list.add(area);
        list.add(area1);
        return list;
    }

    @RequestMapping(value = "hello.html", method = RequestMethod.GET)
    @ResponseBody
    public Object hello() {
        Area area = new Area();
        area.setName("广州");
        area.setId(1);
        area.setPid(2);
        Area area1 = new Area();
        area1.setId(12);
        area1.setName("北京");
        area1.setPid(22);
        Map<String, Object> map = new HashMap<>();
        List<Area> list = new ArrayList<>();
        list.add(area);
        list.add(area1);
        map.put("area", area);
        map.put("result", list);
        System.out.println(JSON.toJSON(map));
        return map;
    }

    @RequestMapping(value = "hello2.html", method = RequestMethod.GET)
    @ResponseBody
    public Object hello2(@RequestParam(value = "id") Integer id,
                         @RequestParam(value = "name") String name) {
        Area area = new Area();
        area.setName("广州");
        area.setId(1);
        area.setPid(2);
        Area area1 = new Area();
        area1.setId(12);
        area1.setName("北京");
        area1.setPid(22);
        Map<String, Object> map = new HashMap<>();
        List<Area> list = new ArrayList<>();
        list.add(area);
        list.add(area1);
        map.put("area", area);
        map.put("result", list);
        return map;
    }

    @RequestMapping(value = "value/map.html", method = RequestMethod.GET)
    public String mapView(ModelMap modelMap) {

        modelMap.addAttribute("name", "zjcscut");
        modelMap.addAttribute("age", 23);
        return "map_view";
    }

    @RequestMapping(value = "value/text.html")
    @ResponseBody
    public String text(){
        String s = "\":30";

        return JsonUtil.toJson(s);
    }

}
