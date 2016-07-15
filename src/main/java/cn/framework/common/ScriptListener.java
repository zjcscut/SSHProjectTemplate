package cn.framework.common;

import cn.framework.entity.ExecuteResult;

/**
 * @author zjc
 * @version 2016/7/13 23:59
 * @function 脚本监听器
 */
public interface ScriptListener {

	void before(ScriptContext context);

	void after(ScriptContext context,ExecuteResult result);
}
