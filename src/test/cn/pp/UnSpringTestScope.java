/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.pp;

import cn.framework.common.DynamicScriptEngineFactory;
import cn.framework.entity.ExecuteResult;
import cn.framework.java.JavaEngine;
import cn.framework.js.JavaScriptEngine;
import cn.pp.common.annotation.impl.CustomSimplePropertyPreFilter;
import cn.pp.entity.*;
import cn.pp.utils.JsonUtil;
import cn.util.http.HttpUtils;
import cn.util.reflect.ReflectionUtils;
import cn.zjcscut.compile.cmd.DynamicCompileWithCmd;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.*;


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
        JavaScriptEngine javaScriptEngine = (JavaScriptEngine) DynamicScriptEngineFactory.getEngine("js");
        javaScriptEngine.compile("test1", code);
        Map<String, Object> params = new HashMap<>();
        params.put("name", "zjcscut");
        ExecuteResult result = javaScriptEngine.execute("tesddt1", params);
        String s = javaScriptEngine.getScriptContext("test1").getSign();
        System.out.println("result---- > " + s);
    }

    @Test
    public void TestJson() {
        String[] s = {"id", "name"};
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
        map.put("area1", area1);
        map.put("result", list);
        CustomSimplePropertyPreFilter filter = new CustomSimplePropertyPreFilter();
        filter.getExcludes().add("id");
        filter.getExcludes().add("name");
        System.out.println(JSON.toJSONString(map, filter));
    }

    @Test
    public void TestJavaEngine() throws Exception {
        JavaEngine javaEngine = new JavaEngine();
        String sourceCode = "package cn.zjc.compile;\n" +
                "\n" +
                "import java.text.SimpleDateFormat;\n" +
                "import java.util.Date;\n" +
                "\n" +
                "public class Target {\n" +
                "\n" +
                "  public static void main(String[] args){\n" +
                "      System.out.println(\"Hello World! Today is \" + new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\").format(new Date()));\n" +
                "  }\n" +
                "}";
        javaEngine.compile("test1", sourceCode);
        System.out.println(javaEngine.execute("test1"));

//        JavaEngine engine = new JavaEngine();
//        String sourceCode2 = "package cn.zjcscut.compile;\n" +
//                "\n" +
//                "import java.text.SimpleDateFormat;\n" +
//                "import java.util.Date;\n" +
//                "\n" +
//                "public class Target {\n" +
//                "\n" +
//                "  public static void main(String[] args){\n" +
//                "      System.out.println(\"Hello World! Today not is\" + new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\").format(new Date()));\n" +
//                "  }\n" +
//                "}";
//        engine.compile("test12",sourceCode2);
//        System.out.println(engine.execute("test12"));
    }

    @Test
    public void Test5() {
        String s = "http://www.baidu.com";
        String[] arr = s.split("\\?");
        System.out.println("re.length==>" + arr.length);
        System.out.println("re==>" + Arrays.toString(arr));
    }

    @Test
    public void testUpload() {
        Map<String, String> params = new HashMap<>(1);
        params.put("name", "zjc");
        List<File> files = new ArrayList<>(2);
        files.add(new File("D://1.txt"));
        files.add(new File("D://2.txt"));
        String re = HttpUtils.getInstance().doMultiPost("http://localhost:9090/sys/test/push/postFile.html", null, params, files).getContent();
        System.out.println("result==>" + re);
    }

    @Test
    public void doChainPost() {
        Map<String, String> params = new HashMap<>(2);
        params.put("name", "zjc");
        String re = HttpUtils.getInstance()
                .addHeader("header1", "value1")
                .addParameter("id", "1")
                .doPost("http://localhost:9090/http/post.html", params)
//                .doGet("http://localhost:9090/http/post.html",params)
                .getContent();
        System.out.println("result==>" + re);
    }

    @Test
    public void TestEmptyList() {
        List EMPTY_LIST = Collections.EMPTY_LIST;
        assertEquals(EMPTY_LIST != null, true);
        assertEquals(EMPTY_LIST.isEmpty(), true);
    }

    @Test
    public void doChainMulti() {

        List<File> files = new ArrayList<>(2);
        files.add(new File("D://1.txt"));
        files.add(new File("D://2.txt"));
        Map<String, String> params = new HashMap<>(2);
        params.put("name", "zjc");
        String re = HttpUtils.getInstance()
                .addParameter("id", "1")
                .doMultiPost("http://localhost:9090/http/multi.html", params, files)
                .getContent();
        System.out.println("result==>" + re);
    }

    @Test
    public void TestAccess() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        A a = new A(1,"zjc");
//        Method m = a.getClass().getDeclaredMethod("me",String.class);
//        ReflectionUtils.setAccessible(m);
//        Object re = m.invoke(a,"zjcscut");
//        System.out.println(re);

        assertTrue(ReflectionUtils.isAssignable(I1.class, Impl.class));
    }

    @Test
    public void TestSG()throws Exception{
        A a = new A();
        ReflectionUtils.setWriteValue(a,"name","zjc");
        assertEquals(ReflectionUtils.getReadValue(a,"name"),"zjc");
    }

    @Test
    public void TestSS() throws Exception{

        A a= new A();
        Field f =a.getClass().getDeclaredField("ss");
        System.out.println(Modifier.toString(f.getModifiers()));
        assertTrue(ReflectionUtils.isPublicStaticFinal(f));
    }
}
