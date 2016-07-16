package cn.framework.common;

import cn.framework.entity.ExecuteResult;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author zhangjinci
 * @version 2016/7/14 9:42
 * @function 监听器支持引擎
 */
public abstract class ListenerSupportEngine implements DynamicScriptEngine{


    protected List<ScriptListener> listeners = new LinkedList<>();

    protected void handleListenerBefore(final ScriptContext scriptContext) {
        listeners.forEach(new Consumer<ScriptListener>() {
            @Override
            public void accept(ScriptListener scriptListener) {
                scriptListener.before(scriptContext);
            }
        });
    }

    protected void handleListenerAfter(final ScriptContext scriptContext,final ExecuteResult executeResult) {
        listeners.forEach(new Consumer<ScriptListener>() {
            @Override
            public void accept(ScriptListener scriptListener) {
                scriptListener.after(scriptContext, executeResult);
            }
        });

    }

    @Override
    public void addListener(ScriptListener scriptListener) {
        listeners.add(scriptListener);
    }
}
