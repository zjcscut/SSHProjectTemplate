package cn.framework.groovy;

import cn.framework.common.AbstractScriptEngine;


/**
 * @author zhangjinci
 * @version 2016/7/14 10:35
 * @function Groovy脚本引擎
 */
public class GroovyEngine extends AbstractScriptEngine{

    @Override
    protected String getScriptName() {
        return "groovy";
    }
}
