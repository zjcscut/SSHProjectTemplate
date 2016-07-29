package cn.pp.controller;

import cn.pp.entity.Area;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * @author zhangjinci
 * @version 2016/7/29 10:14
 * @function
 */
@Controller
public class AsyncController {


    @RequestMapping(value = "/async.html")
    public String getView() {
        return "async";
    }

    @RequestMapping(value = "/async/getData.html", method = RequestMethod.POST)
    @ResponseBody
    public Object getJsonData() {
        List<Area> areas = new ArrayList<>();
        areas.add(new Area(1, "广东", 0));
        areas.add(new Area(2, "上海", 0));
        areas.add(new Area(3, "北京", 0));
        areas.add(new Area(4, "广西", 0));
        areas.add(new Area(5, "重庆", 0));
        areas.add(new Area(5, "重庆", 0));
        areas.add(new Area(5, "重庆", 0));
        areas.add(new Area(5, "重庆", 0));
        areas.add(new Area(6, "PPP", 0));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "0");
        jsonObject.put("areas", areas);
        return jsonObject.toJSONString();
    }
}
