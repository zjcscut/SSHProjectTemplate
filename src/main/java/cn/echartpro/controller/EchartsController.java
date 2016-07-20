package cn.echartpro.controller;

import cn.echartpro.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author zhangjinci
 * @version 2016/7/20 20:37
 * @function
 */
@Controller
public class EchartsController {

    @Autowired
    private EchartsService echartsService;
}
