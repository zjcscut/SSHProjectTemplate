package cn.zjcscut.freemarker.config;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import java.util.Locale;


/**
 * @author zjc
 * @version 2016/7/11 23:02
 * @function FreeMarker基本配置，以及获取FreeMarker实例
 */
public class FreeMarkerConfig {


    private static final String DEFAULT_CHARSET = "UTF-8";

    private static  Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);

    public static Configuration getInstance(){
        cfg.setEncoding(Locale.getDefault(), DEFAULT_CHARSET);    //根据默认地区设置默认编码
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER); //默认异常处理器
        return cfg;
    }

    private FreeMarkerConfig(){

    }

}
