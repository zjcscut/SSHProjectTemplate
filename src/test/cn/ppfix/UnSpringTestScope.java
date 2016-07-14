package cn.ppfix;

import cn.ppfix.utils.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zjc
 * @version 2016/6/9 22:39
 */
public class UnSpringTestScope {

    private final static Logger log = LogManager.getLogger(UnSpringTestScope.class);

    @Test
    public void Test1() {
        System.out.println(JsonUtil.toJson(null));
    }


    @Test
    public void Test2() {
        String name = "zjc";
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        log.debug("Hello {},today is {}", name, date);
        log.debug("Hello World! Today is" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }
}
