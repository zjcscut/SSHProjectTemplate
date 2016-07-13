package cn.zjcscut.jswrap;

import javax.script.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/7/13 10:27
 * @function 编译Js脚本并且执行
 */
public class ScriptCompile {


    public CompiledScript compile(String scriptText, Map<String, Object> value) throws ScriptException {
        ScriptEngine engine = new ScriptManagerConfig().getEngine();  //引擎先进行值绑定再进行编译输出
        Bindings bindings = engine.createBindings();

        if (value != null && !value.isEmpty()) {
            bindings.putAll(value);
        }

        if (engine instanceof Compilable) {
            CompiledScript script = ((Compilable) engine).compile(scriptText);
            return script;
        }
        return null;
    }


    //先编译再执行(一般先编译后执行效率比直接解析脚本高很多)
    public void run(String scriptText, Map<String, Object> val) throws ScriptException {
        CompiledScript script = compile(scriptText, val); //编译
        if (script == null) {
            return;
        }
        for (int i = 0; i < 100; i++) {  //执行100次
            script.eval();
        }
    }

    public static void main(String[] args) {
        ScriptCompile sc = new ScriptCompile();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "zjc");
            map.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            sc.run("print('Hello ' + name + ' today is ' + date)", map);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
