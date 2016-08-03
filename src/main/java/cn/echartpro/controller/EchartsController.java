package cn.echartpro.controller;

import cn.echartpro.service.EchartsService;
import cn.pp.utils.JsonUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/7/20 20:37
 * @function
 */
@Controller
public class EchartsController {

    private static final Logger log = LoggerFactory.getLogger(EchartsController.class);

    @Autowired
    private EchartsService echartsService;

    @RequestMapping(value = "echart/view.html")
    public String getEchartsView() {
        return "echarts_map";
    }

    @RequestMapping(value = "echart/data/get.html", method = RequestMethod.GET)
    @ResponseBody
    public String getEchartsData() {
        log.error("打印echarts data --- " + echartsService.getData());
        return JsonUtil.toJson(echartsService.getData());
    }

    @RequestMapping(value = "echart/dynamic/rosechart.html")
    public String getRosechart() {
        return "rosechart";
    }

    @RequestMapping(value = "echart/rosechart/data.html",method = RequestMethod.GET)
    @ResponseBody
    public String getRosechartData() {
        JSONObject result = new JSONObject();
        List<JSONObject> datas = echartsService.getData();
        String[] array = new String[datas.size()];
        for (int i = 0; i < datas.size(); i++) {
            array[i] = (String) datas.get(i).get("name");
        }
        result.put("datas", datas);
        result.put("names", array);
        log.error(JsonUtil.toJson(result));
        return JsonUtil.toJson(result);
    }

	@RequestMapping(value = "echart/dynamic/barchart.html")
	public String getDynamicBarchart() {
		return "dynamic_bar";
	}
}
