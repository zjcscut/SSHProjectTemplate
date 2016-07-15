package cn.framework.spel;

import cn.framework.common.AbstractScriptEngine;

/**
 * @author zhangjinci
 * @version 2016/7/15 16:58
 * @function Spring EL脚本引擎(目前尚不支持)
 */
public class SpringELEngine extends AbstractScriptEngine{

    @Override
    public String getScriptName() {
        return "spel";
    }
}
