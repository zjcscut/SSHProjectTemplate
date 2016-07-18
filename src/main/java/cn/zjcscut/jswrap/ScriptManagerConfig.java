package cn.zjcscut.jswrap;

import javax.script.*;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/7/13 9:32
 * @function Java调用Js脚本的例子，如果是jdk1.6 基于Rhino实现，效率比较低；
 * 如果是jdk 1.8，基于Nashorn实现，效率比较高
 */
public class ScriptManagerConfig {


    //适配Jdk版本返回适当的引擎
    public ScriptEngine getEngine() throws ScriptException{
        String engineName = "JavaScript"; //jdk 1.8以下(其实可以通用"JavaScript")
        String version =  System.getProperty("java.version");
        System.out.println(version + "--------------------------------");
        if (version.startsWith("1.8")){
            engineName = "Nashorn";  //jdk 1.8
        }
        return new ScriptEngineManager().getEngineByName(engineName);
    }


    //显示当前版本以及相关信息
    public String show() {
        String version = "";
        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = manager.getEngineFactories();
        for (ScriptEngineFactory factory : factories) {
            System.out.printf("Name: %s%n" + "Version: %s%n" +
                            "Language name: %s%n" +
                            "Language version: %s%n" +
                            "Extensions: %s%n" +
                            "Mime types: %s%n" +
                            "Names: %s%n",
                    factory.getEngineName(),
                    factory.getEngineVersion(),
                    factory.getLanguageName(),
                    factory.getLanguageVersion(),
                    factory.getExtensions(),
                    factory.getMimeTypes(),
                    factory.getNames());
            version = factory.getEngineVersion();
        }
        return version;
    }

    public void greet() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("Nashorn");

//        ScriptEngine engine = manager.getEngineByExtension("js");
//        ScriptEngine engine = manager.getEngineByMimeType("text/javascript");
        if (engine == null) {
            throw new RuntimeException("找不到JavaScript语言执行引擎");
        }
        engine.put("name", "Alex");
        engine.eval("var message = 'Hello, ' + name;");
        engine.eval("print(message);");
//        Object obj = engine.get("message");
//        System.out.println(obj);
    }


    public void SimpleBingdingTest() throws Exception{  //值绑定
        int val = 10;
        SimpleBindings simpleBindings = new SimpleBindings();
        simpleBindings.put("globalVal",val);
        getEngine().eval("print(globalVal)",simpleBindings);
    }



    public static void main(String[] args) {
        try {
            new ScriptManagerConfig().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
