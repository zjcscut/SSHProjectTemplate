package cn.framework.common;

import cn.framework.groovy.GroovyEngine;
import cn.framework.java.JavaEngine;
import cn.framework.js.JavaScriptEngine;
import cn.framework.ognl.OgnlEngine;
import cn.framework.python.PythonEngine;
import cn.framework.ruby.RubyEngine;
import cn.framework.scala.ScalaEngine;
import cn.framework.spel.SpringELEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/7/14 10:23
 * @function 动态脚本引擎工厂
 */
public class DynamicScriptEngineFactory {

    private final static Logger log = LogManager.getLogger(DynamicScriptEngineFactory.class);

    private final static Map<String, DynamicScriptEngine> engines = new HashMap<>();

    static {
        JavaScriptEngine jsEngine = new JavaScriptEngine();
        engines.put("js", jsEngine);
        engines.put("JavaScript", jsEngine);
        engines.put("Nashorn", jsEngine);
        engines.put("groovy", new GroovyEngine());

        engines.put("python", new PythonEngine());
        engines.put("ruby", new RubyEngine());
        engines.put("scala", new ScalaEngine());

        //分别捕捉额外脚本引擎加载的异常
        try {
            engines.put("java", new JavaEngine());
        } catch (Exception e) {
            log.warn("load {} engine failed", "java");
        }

        try {
            //        engines.put("ognl",new OgnlEngine());   //需要额外整合
        } catch (Exception e) {
            log.warn("load {} engine failed", "ognl");
        }

        try {
            //        engines.put("spEL",new SpringELEngine());  //需要额外整合
        } catch (Exception e) {
            log.warn("load {} engine failed", "spel");
        }
    }


    public static DynamicScriptEngine getEngine(String type) {
        return engines.get(type);
    }
}
