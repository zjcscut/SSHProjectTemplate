package cn.echartpro.controller;

import cn.echartpro.service.EchartsService;
import cn.ppfix.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
