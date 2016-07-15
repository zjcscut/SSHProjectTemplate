package cn.framework.common;

import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/7/14 9:45
 * @function 动态脚本引擎
 */
public interface DynamicScriptEngine {

    void init(String...contents) throws Exception;

    ScriptContext getScriptContext(String id);

    boolean compile(String id,String sourceCode);

    boolean compiled(String id);

    ExecuteResult execute(String id, Map<String,Object> params);

    ExecuteResult execute(String id);

    void addListener(ScriptListener scriptListener);

    boolean remove(String id);
}
