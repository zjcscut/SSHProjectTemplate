package cn.framework.scala;

import cn.framework.common.AbstractScriptEngine;

/**
 * @author zhangjinci
 * @version 2016/7/15 16:36
 * @function Scala脚本引擎(目前尚未支持)
 */
public class ScalaEngine  extends AbstractScriptEngine{

    @Override
    protected String getScriptName() {
        return "scala";
    }
}
