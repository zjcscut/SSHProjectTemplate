package cn.zjcscut.freemarker.config;

import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/7/12 16:03
 */
public interface FreeMarkerRender {

    String render(Map<String,Object> data) throws Exception;
}
