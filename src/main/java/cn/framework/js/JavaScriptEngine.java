package cn.framework.js;

import cn.framework.common.AbstractScriptEngine;
import cn.framework.common.ExecuteResult;
import cn.framework.common.ScriptContext;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

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
        } else if (version.startsWith("1.8")) {
            return "Nashorn";
        }
        return "JavaScript";
    }

    @Override
    public boolean compile(String id, String sourceCode) {
        if (log.isDebugEnabled()) {
            log.debug("complie {} {}:{}", getScriptName(), id, sourceCode);
        }
        //获取编译器

        //从工厂获取引擎

        return true;
    }
}
