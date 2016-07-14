package cn.framework.common;

/**
 * @author zjc
 * @version 2016/7/13 23:59
 * @function
 */
public interface ScriptListener {

	void before(ScriptContext context);

	void after(ScriptContext context,ExcuteResult result);
}
