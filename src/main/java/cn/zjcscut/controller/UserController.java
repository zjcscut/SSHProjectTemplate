package cn.zjcscut.controller;

import cn.zjcscut.service.UserService;
import cn.zjcscut.utils.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zjc
 * @version 2016/5/13 1:41
 */
@Controller
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "test/{age}")
    @ResponseBody
    public String Test(@PathVariable(value = "age") Integer age) {
        return JsonUtil.toJson(userService.findUserByAge(age));
    }
}
