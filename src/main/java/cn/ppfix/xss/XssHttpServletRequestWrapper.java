package cn.ppfix.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

/**
 * @author zhangjinci
 * @version 2016/6/23 16:01
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {


    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }


    //重写getParameterMap()应该会比较完善，因为struct2依赖于此
    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> reslut = new HashMap<>();
        Map<String, String[]> paramMap = new HashMap<>(super.getParameterMap());
        if (null != paramMap && paramMap.size() > 0) {
            Set<String> keys = paramMap.keySet();
            for (String key : keys) {
                String req = Arrays.toString(paramMap.get(key)).substring(1, Arrays.toString(paramMap.get(key)).length() - 1);
                reslut.put(xssEncode(key), xssEncode(req).split(",")); //修正前后多出的"[ ]"
            }
        }
        return reslut;
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(xssEncode(name));
        if (null != value && !"".equals(value))
            value = xssEncode(value);
        return value;
    }


    @Override
    public String getHeader(String name) {
        String value = super.getHeader(xssEncode(name));
        if (null != value && !"".equals(value))
            value = xssEncode(value);
        return value;
    }

    private static String xssEncode(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '>':
                    sb.append('＞');//全角大于号
                    break;
                case '<':
                    sb.append('＜');//全角小于号
                    break;
                case '\'':
                    sb.append('‘');//全角单引号
                    break;
                case '\"':
                    sb.append('“');//全角双引号
                    break;
                case '&':
                    sb.append('＆');//全角
                    break;
                case '\\':
                    sb.append('＼');//全角斜线
                    break;
                case '#':
                    sb.append('＃');//全角井号
                    break;
                case '%':
                    sb.append("％");//全角%号
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

}
