package cn.framework.common;

import cn.framework.entity.ExecuteResult;
import cn.pp.utils.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.script.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author zjc
 * @version 2016/7/13 23:58
 * @function 抽象模板引擎(继承于监听器支持引擎)
 */
public abstract class AbstractScriptEngine extends ListenerSupportEngine {

    protected static final Logger log = LoggerFactory.getLogger(AbstractScriptEngine.class);

    //获取脚本名字
    protected abstract String getScriptName();

    //编译器
    protected Compilable compilable;

    //脚本库
    protected Map<String, AbstractScriptContext> scripts = new ConcurrentHashMap<>();

    //绑定器
    protected Bindings bindings;

    //脚本执行监听器
    protected List<ScriptListener> scriptListeners;

    public AbstractScriptEngine() {
        try {
            init();    //初始化操作
        } catch (Exception e) {
            log.warn("init {} failed", getScriptName());
        }
    }

    @Override
    public List<ScriptEngineFactory> getLocalEngineInfo() {
        return null;
    }

    @Override
    public void init(String... contents) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName(getScriptName()); //获取脚本引擎
        compilable = (Compilable) engine;
        CompiledScript script;
        for (String c : contents) {
            script = compilable.compile(c);
            script.eval(bindings);
        }
        scripts.clear();  //清空全部脚本缓存
    }

    @Override
    public ScriptContext getScriptContext(String id) {  //获取上下文
        return scripts.get(id);
    }

    @Override
    public boolean compile(String id, String sourceCode) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("compile by ScriptEngine {}", getScriptName());//把编译内容记录进日志
            log.debug("target : {}",id);
            log.debug("script content : \n" + sourceCode);
        }
        if (compilable == null) {
            init();
        }
        CompiledScript script = compilable.compile(sourceCode);
        AbstractScriptContext abstractScriptContext = new AbstractScriptContext(id, MD5.getMD5(sourceCode), script); //上下文中，源码转换信息摘要
        scripts.put(id, abstractScriptContext);
        return true;
    }

    @Override
    public ExecuteResult execute(String id, Map<String, Object> params) {
        long startTime = System.currentTimeMillis();
        if (log.isDebugEnabled()) {
            log.debug("execute  {} : {}", id,"by ScriptEngine " + getScriptName());
        }
        ExecuteResult result = new ExecuteResult();
        AbstractScriptContext scriptContext = scripts.get(id);
        try {
            if (scriptContext != null) {
                handleListenerBefore(scriptContext);  //前置监听器
                javax.script.ScriptContext context = new SimpleScriptContext();
                context.setBindings(bindings, javax.script.ScriptContext.GLOBAL_SCOPE);
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    context.setAttribute(entry.getKey(), entry.getValue(), javax.script.ScriptContext.ENGINE_SCOPE);
                }
                result.setResult(scriptContext.getScript().eval(context));  //获取返回的结果
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
                result.setResult(null);
                result.setMsg(String.format("scriptEngine (%s): %s not found!", getScriptName(), id));
            }
        } catch (Exception e) {
            log.error("execute {}:{} failed", getScriptName(), id);
            result.setException(e);
        }
        result.setCostTime(System.currentTimeMillis() - startTime);
        handleListenerAfter(scriptContext, result);  //后置监听器
        log.debug(result.toString());
        return result;
    }

    @Override
    public ExecuteResult execute(String id) {
        return execute(id, new HashMap<String, Object>());
    }

    @Override
    public boolean remove(String id) {
        return scripts.remove(id) != null;
    }

    @Override
    public void addListener(ScriptListener scriptListener) {
        if (scriptListeners == null) {
            scriptListeners = new LinkedList<>();
        }
        scriptListeners.add(scriptListener);
    }

    //抽象类用于保存编译环境上下文
    protected class AbstractScriptContext extends ScriptContext {
        protected CompiledScript script;

        public AbstractScriptContext(String id, String sign, CompiledScript script) {
            super(id, sign);
            this.script = script;
        }

        public CompiledScript getScript() {
            return script;
        }
    }
}
