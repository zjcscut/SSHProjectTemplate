package cn.zjcscut.freemarker.config;

import cn.zjcscut.freemarker.classUtils.ClassLoader;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/7/12 12:08
 * @function FreeMarker默认模板加载器适配类(方法比较直接粗暴)
 */
public class DefaultTemplateLoaderAdapter {

    private static final Logger log = LoggerFactory.getLogger(DefaultTemplateLoaderAdapter.class);

    private static final String DEFAULT_INPUT_CHARSET = "UTF-8";  //默认模板输入字符编码

    private static final String DEFAULT_OUTPUT_CHARSET = "UTF-8";  //默认模板输出字符编码

    private static Configuration cfg = FreeMarkerConfig.getInstance();  //初始化FreeMarker实例

    private static Template template;

    //初始化模板设置
    public static void init(String inCharset, String inDirsPath, String templateName) {
        inCharset = StringUtils.isEmpty(inCharset) ? DEFAULT_INPUT_CHARSET : inCharset;

        try {
            cfg.setDirectoryForTemplateLoading(
                    new File(ClassLoader.getClassPath(DefaultTemplateLoaderAdapter.class) + inDirsPath));
            template = cfg.getTemplate(templateName, Locale.getDefault(), inCharset);
        } catch (IOException e) {
            log.error("读取FreeMarker模板失败,请确认模板路径和模板文件名的正确性", e.getMessage());
            e.printStackTrace();
        }
    }

    //渲染输出root中封装了要输出的数据
    @SuppressWarnings({"TryWithIdenticalCatches", "ResultOfMethodCallIgnored"})
    public static void compile(Map<String, Object> root, String outCharset,
                               String outDirsPath, String outFileName) {
        outCharset = StringUtils.isEmpty(outCharset) ? DEFAULT_OUTPUT_CHARSET : outCharset;
        String realPath = outDirsPath + outFileName;
        Writer out  = null;
        try {
            File file = new File(realPath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();  //如果文件不存在，创建其父级路径
            }
            out = new OutputStreamWriter(new FileOutputStream(realPath));
            Environment environment = template.createProcessingEnvironment(root, out);
            environment.setOutputEncoding(outCharset);  //设置输出编码格式
            environment.process();
        } catch (IOException e) {
            log.error("渲染文件失败，找不到输出文件路径", e.getMessage());
            e.printStackTrace();
        } catch (TemplateException te) {
            log.error("渲染文件失败,模板信息异常", te.getMessage());
            te.printStackTrace();
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("关闭文件输出流失败", e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        init(null, "/template", "test.ftl");

        Map<String, Object> root = new HashMap<>();
        root.put("user", "zjcscut");
        Map<String, Object> last = new HashMap<>();
        root.put("latestProduct", last);
        last.put("url", "https://www.baidu.com");
        last.put("name", "犀利世界");
        compile(root, null, "D:/freemarker/out/", "test.html");
    }

}
