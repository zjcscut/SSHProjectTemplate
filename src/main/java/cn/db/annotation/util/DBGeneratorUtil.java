/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.db.annotation.util;

/**
 * @author zhangjinci
 * @version 2016/8/22 18:49
 * @function
 */
public class DBGeneratorUtil {

    /**
     * 拼接空格
     * @param sb
     * @param n
     */
    public static void writeBlankSpace(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
    }
}
