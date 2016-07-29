package cn.pp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangjinci
 * @version 2016/7/29 17:56
 * @function
 */
@Controller
public class ThemeController {

    @RequestMapping(value = "/theme/index.html")
    public String index(){
        return "theme-index";
    }
}
