/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.util.http.origin.api;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/9/14 9:50
 * @function 原生Http工具类, 不依赖于任何的jar包
 */
public class NativeHttpUtils  implements AutoCloseable{

    private Map<String, Object> params; //手动添加的参数

    public NativeHttpUtils addParamter(String key, Object value) {
        this.params.put(key, value);
        return this;
    }

    private static final NativeHttpUtils single = new NativeHttpUtils();

    private NativeHttpUtils() {
        params = new HashMap<>();
    }

    public static NativeHttpUtils getInstance() {
        return single;
    }


    //把参数map释放
    @Override
    public void close() throws Exception {
        params.clear();
    }
}
