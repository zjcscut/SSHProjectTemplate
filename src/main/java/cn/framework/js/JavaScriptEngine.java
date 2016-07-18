package cn.framework.js;

import cn.framework.common.AbstractScriptEngine;
import cn.ppfix.utils.MD5;
import org.apache.commons.lang3.StringUtils;

import javax.script.CompiledScript;

/**
 * @author zhangjinci
 * @version 2016/7/14 10:22
 * @function JavaScript脚本引擎
 */
public class JavaScriptEngine extends AbstractScriptEngine {

    //适配jdk版本获取脚本名称
    @Override
    protected String getScriptName() {
        String version = System.getProperty("java.version");
        if (StringUtils.isEmpty(version)) {
            throw new RuntimeException("获取Jdk版本失败");
        } else if (version.startsWith("1.8")) {  //适配jdk1.8，解析JS的引擎改变了
            return "Nashorn";
        }
        return "JavaScript";
    }

    @Override
    public boolean compile(String id, String sourceCode) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("compile by ScriptEngine {}", getScriptName());//把编译内容记录进日志
            log.debug("target : {}",id);
            log.debug("script content : \n" + sourceCode);
        }
        if (compilable == null)
            init();
        CompiledScript compiledScript = compilable.compile(sourceCode);
        AbstractScriptContext scriptContext = new AbstractScriptContext(id, MD5.getMD5(sourceCode), compiledScript);
        scripts.put(id, scriptContext);
        return true;
    }
}
