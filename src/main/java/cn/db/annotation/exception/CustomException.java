/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.db.annotation.exception;

/**
 * @author zhangjinci
 * @version 2016/8/22 9:51
 * @function
 */
public class CustomException extends RuntimeException{

    private String msg;

    private String code;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
        this.msg = message;
    }

    public CustomException(String msg, String code) {
        super();
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
