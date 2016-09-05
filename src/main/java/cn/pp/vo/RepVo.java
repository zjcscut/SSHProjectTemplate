/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.pp.vo;

/**
 * @author zhangjinci
 * @version 2016/9/1 15:51
 * @function
 */
public class RepVo {

    private String  returnCode;
    private String msg;

    public RepVo(String returnCode, String msg) {
        this.returnCode = returnCode;
        this.msg = msg;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
