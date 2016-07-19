package cn.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author zhangjinci
 * @version 2016/7/19 13:25
 * @function
 */
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:dispatcher-servlet.xml","classpath:spring-activiti.xml"})
public class AbstractContextControllerTests {

    @Autowired
    protected WebApplicationContext context;
}
