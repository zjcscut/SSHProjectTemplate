package cn.framework.common;

/**
 * @author zjc
 * @version 2016/7/14 0:04
 * @function Script上下文
 */
public class ScriptContext {

    private String id;    //id
    private String sign;  //签名

    public ScriptContext(String id, String sign) {
        this.id = id;
        this.sign = sign;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
