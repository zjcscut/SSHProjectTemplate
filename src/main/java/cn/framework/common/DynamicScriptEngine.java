package cn.framework.common;

import cn.framework.entity.ExecuteResult;

import javax.script.ScriptEngineFactory;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/7/14 9:45
 * @function 动态脚本引擎
 */
public interface
DynamicScriptEngine {

    List<ScriptEngineFactory> getLocalEngineInfo();  //获取本地引擎信息

    void init(String...contents) throws Exception;

    ScriptContext getScriptContext(String id);

    boolean compile(String id,String sourceCode)throws Exception;

    ExecuteResult execute(String id, Map<String,Object> params);

    ExecuteResult execute(String id);

    void addListener(ScriptListener scriptListener);

    boolean remove(String id);
}
