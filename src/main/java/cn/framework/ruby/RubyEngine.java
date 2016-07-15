package cn.framework.ruby;

import cn.framework.common.AbstractScriptEngine;

/**
 * @author zhangjinci
 * @version 2016/7/14 10:38
 * @function Ruby脚本引擎
 */
public class RubyEngine extends AbstractScriptEngine{

    @Override
    protected String getScriptName() {
        return "ruby";
    }
}
