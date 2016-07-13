package cn.zjcscut.compile;

import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.net.URI;

/**
 * @author zhangjinci
 * @version 2016/7/13 16:09
 * @function 定制 JavaFileObject 对象
 */
public class StringObject extends SimpleJavaFileObject {

    private String contents = null;

    public StringObject(String className, String contents) throws Exception {
        super(new URI(className), Kind.SOURCE);
        this.contents = contents;
    }

    public CharSequence getCharContent(boolean ignoreEncodingErrors)
            throws IOException {
        return contents;
    }
}
