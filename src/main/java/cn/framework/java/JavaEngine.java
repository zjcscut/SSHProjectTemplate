package cn.framework.java;

import cn.framework.common.*;
import cn.framework.entity.ExecuteResult;

import java.util.Map;


/**
 * @author zhangjinci
 * @version 2016/7/15 11:02
 * @function
 */
public class JavaEngine  extends AbstractScriptEngine{

    public JavaEngine() throws Exception{
        String dirPath = System.getProperty("user.dir");  //获取当前工作目录
    }

    @Override
    protected String getScriptName() {
        return "java";
    }

    @Override
    public void init(String... contents) throws Exception {

    }

    @Override
    public ScriptContext getScriptContext(String id) {
        return null;
    }

    @Override
    public boolean compile(String id, String sourceCode) {
        return false;
    }

    @Override
    public ExecuteResult execute(String id, Map<String, Object> params) {
        return null;
    }

    @Override
    public ExecuteResult execute(String id) {
        return null;
    }

    @Override
    public boolean remove(String id) {
        return false;
    }
}
