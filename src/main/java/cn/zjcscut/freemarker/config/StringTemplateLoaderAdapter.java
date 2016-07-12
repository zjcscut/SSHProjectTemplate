package cn.zjcscut.freemarker.config;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/7/12 12:07
 * @function FreeMarker字符串模板加载器适配类
 */
public class StringTemplateLoaderAdapter {


    private static StringTemplateLoader loader = new StringTemplateLoader();

    private static Configuration cfg = FreeMarkerConfig.getInstance();  //初始化FreeMarker实例

    static {
        cfg.setTemplateLoader(loader);  //装载StringTemplateLoader
    }


    public static FreeMarkerRender compile(final String content) {
        StringTemplateLoader templateLoader = (StringTemplateLoader) cfg.getTemplateLoader();
        final String templateName = "template#" + content.hashCode(); //构造唯一的模板名称
        templateLoader.putTemplate(templateName, content);
        cfg.setTemplateLoader(templateLoader);
        return new FreeMarkerRender() {
            @Override
            public String render(Map<String, Object> data) throws Exception {
                Template template = cfg.getTemplate(templateName);
                StringWriter out = new StringWriter();
                template.process(data, out);
                return out.getBuffer().toString();
            }
        };
    }

    public static void main(String[] args) throws Exception{
        FreeMarkerRender render = compile("<html>\n" +
                "<head>\n" +
                "    <title>Welcome!</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Welcome ${user}!</h1>\n" +
                "<p>Our latest product:\n" +
                "    <a href=\"${latestProduct.url}\">${latestProduct.name}</a><p>\n" +
                "</body>\n" +
                "</html>");

        Map<String, Object> root = new HashMap<>();
        root.put("user", "zjcscut");
        Map<String, Object> last = new HashMap<>();
        root.put("latestProduct", last);
        last.put("url", "https://www.baidu.com");
        last.put("name", "犀利世界");
        System.out.println(render.render(root));
    }

}
