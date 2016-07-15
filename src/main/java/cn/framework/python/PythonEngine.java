package cn.framework.python;

import cn.framework.common.AbstractScriptEngine;

/**
 * @author zhangjinci
 * @version 2016/7/15 12:09
 * @function Python解析引擎(目前尚未支持)
 */
public class PythonEngine extends AbstractScriptEngine{

    @Override
    protected String getScriptName() {
        return "python";
    }
}
