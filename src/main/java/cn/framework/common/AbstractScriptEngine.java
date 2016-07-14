package cn.framework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * @author zjc
 * @version 2016/7/13 23:58
 * @function 抽象模板引擎(继承于监听器支持引擎)
 */
public abstract class AbstractScriptEngine extends ListenerSupportEngine{

	protected static final Logger log = LogManager.getLogger(AbstractScriptEngine.class);

    protected abstract String getScriptName();

    @Override
    public void init(String... contents) throws Exception {

    }

    @Override
    public ScriptContext getScriptContext(String id) {
        return null;
    }

    @Override
    public boolean compile(String id, String sourceCode) {
        return false;
    }

    @Override
    public boolean compiled(String id) {
        return false;
    }

    @Override
    public ExecuteResult execute(String id, Map<String, Object> params) {
        return null;
    }

    @Override
    public ExecuteResult execute(String id) {
        return null;
    }

    @Override
    public boolean remove(String id) {
        return false;
    }
}
