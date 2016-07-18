package cn.framework.java;

import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/7/15 12:16
 * @function 提交器接口
 */
public interface Executor {

    Object execute(Map<String, Object> params) throws Exception;
}
