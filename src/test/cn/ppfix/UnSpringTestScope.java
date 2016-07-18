package cn.ppfix;

import cn.framework.common.DynamicScriptEngineFactory;
import cn.framework.common.ScriptListener;
import cn.framework.entity.ExecuteResult;
import cn.framework.js.JavaScriptEngine;
import cn.ppfix.utils.JsonUtil;
import cn.zjcscut.compile.cmd.DynamicCompileWithCmd;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author zjc
 * @version 2016/6/9 22:39
 */
public class UnSpringTestScope {

    private final static Logger log = LoggerFactory.getLogger(UnSpringTestScope.class);

    @Test
    public void Test1() {
        System.out.println(JsonUtil.toJson(null));
    }


    @Test
    public void Test2() {
        String name = "zjc";
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        log.debug("Hello {},today is {}", name, date);
        log.debug("Hello World! Today is " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    @Test
    public void Test3() {
        String code = "import java.text.SimpleDateFormat;\n" +
                "import java.util.Date;\n" +
                "\n" +
                "public class Target {\n" +
                "\n" +
                "  public static void main(String[] args){\n" +
                "      System.out.println(\"Hello World! Today is \" + new SimpleDateFormat(\"yyyy-MM-dd\").format(new Date()));\n" +
                "  }\n" +
                "}";
        DynamicCompileWithCmd cmd = new DynamicCompileWithCmd();
        String re = cmd.execute(code);
        log.error(re);
    }

    @Test
    public void Test4() throws Exception {
        String code = "var s = name;\n print('Hello ' + s);";
        JavaScriptEngine javaScriptEngine = (JavaScriptEngine)DynamicScriptEngineFactory.getEngine("js");
        javaScriptEngine.compile("test1", code);
        Map<String,Object> params = new HashMap<>();
        params.put("name","zjcscut");
        ExecuteResult result = javaScriptEngine.execute("tesddt1",params);
       String  s = javaScriptEngine.getScriptContext("test1").getSign();
        System.out.println("result---- > " + s);
    }
}
