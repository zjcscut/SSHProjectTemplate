/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.util.number;

import cn.util.asser.Assert;

import java.math.BigDecimal;

/**
 * @author zhangjinci
 * @version 2016/10/7 9:16
 * @function 金额计算工具类
 * @description 保持金额精度不丢失
 */
public class BigDecimalUtil {

    private static final int DEFAULT_SCALA = 2; //默认精度

    /**
     * 加法
     *
     * @param augend 被加数
     * @param addend 加数
     * @return 返回和
     */
    public static Double add(String augend, String... addend) {
        BigDecimal n1 = new BigDecimal(augend);
        for (String s : addend) {
            BigDecimal n2 = new BigDecimal(s);
            n1 = n1.add(n2);
        }
        return n1.doubleValue();
    }

    /**
     * 加法
     *
     * @param augend 被加数
     * @param addend 加数
     * @return 返回和
     */
    public static Double add(Double augend, Double... addend) {
        BigDecimal n1 = BigDecimal.valueOf(augend);
        for (Double s : addend) {
            BigDecimal n2 = BigDecimal.valueOf(s);
            n1 = n1.add(n2);
        }
        return n1.doubleValue();
    }

    /**
     * 减法
     *
     * @param minuend    被减数
     * @param subtractor 减数
     * @return 返回差
     */
    public static Double subtract(String minuend, String... subtractor) {
        BigDecimal n1 = new BigDecimal(minuend);
        for (String s : subtractor) {
            BigDecimal n2 = new BigDecimal(s);
            n1 = n1.subtract(n2);
        }
        return n1.doubleValue();
    }

    /**
     * 减法
     *
     * @param minuend    被减数
     * @param subtractor 减数
     * @return 返回差
     */
    public static Double subtract(Double minuend, Double... subtractor) {
        BigDecimal n1 = BigDecimal.valueOf(minuend);
        for (Double s : subtractor) {
            BigDecimal n2 = BigDecimal.valueOf(s);
            n1 = n1.subtract(n2);
        }
        return n1.doubleValue();
    }

    /**
     * 乘法
     *
     * @param multiplicand 被乘数
     * @param multipliers  乘数
     * @return 返回积
     */
    public static double multiply(Double multiplicand, Double... multipliers) {
        BigDecimal n1 = BigDecimal.valueOf(multiplicand);
        for (double multiplier : multipliers) {
            BigDecimal n2 = BigDecimal.valueOf(multiplier);
            n1 = n1.multiply(n2);
        }
        return n1.doubleValue();
    }

    /**
     * 乘法
     *
     * @param multiplicand 被乘数
     * @param multipliers  乘数
     * @return 返回积
     */
    public static double multiply(String multiplicand, String... multipliers) {
        BigDecimal n1 = new BigDecimal(multiplicand);
        for (String multiplier : multipliers) {
            BigDecimal n2 = new BigDecimal(multiplier);
            n1 = n1.multiply(n2);
        }
        return n1.doubleValue();
    }

    /**
     * 除法
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return 返回商
     */
    public static Double divide(Double dividend, Double... divisor) {
        BigDecimal n1 = BigDecimal.valueOf(dividend);
        for (Double s : divisor) {
            BigDecimal n2 = BigDecimal.valueOf(s);
            n1 = n1.divide(n2, DEFAULT_SCALA, BigDecimal.ROUND_HALF_UP); //保留两位小数,四舍五入
        }
        return n1.doubleValue();
    }

    /**
     * 除法
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return 返回商
     */
    public static Double divide(String dividend, String... divisor) {
        BigDecimal n1 = new BigDecimal(dividend);
        for (String s : divisor) {
            BigDecimal n2 = new BigDecimal(s);
            n1 = n1.divide(n2, DEFAULT_SCALA, BigDecimal.ROUND_HALF_UP); //保留两位小数,四舍五入
        }
        return n1.doubleValue();
    }

    /**
     * 除法
     *
     * @param dividend    被除数
     * @param scala       精度
     * @param roundingMod 舍入模式
     * @param divisor     除数
     * @return 返回商
     */
    public static Double divide(Double dividend, Integer scala, Integer roundingMod, Double... divisor) {
        BigDecimal n1 = BigDecimal.valueOf(dividend);
        for (Double s : divisor) {
            BigDecimal n2 = BigDecimal.valueOf(s);
            n1 = n1.divide(n2, scala, roundingMod);
        }
        return n1.doubleValue();
    }

    /**
     * 除法
     *
     * @param dividend     被除数
     * @param scala        精度
     * @param roundingMode 舍入模式
     * @param divisor      除数
     * @return 返回商
     */
    public static Double divide(String dividend, Integer scala, Integer roundingMode, String... divisor) {
        BigDecimal n1 = new BigDecimal(dividend);
        for (String s : divisor) {
            BigDecimal n2 = new BigDecimal(s);
            n1 = n1.divide(n2, scala, roundingMode); //保留两位小数,四舍五入
        }
        return n1.doubleValue();
    }

    /**
     * 截取精度
     *
     * @param value        源值
     * @param scale        精度
     * @param roundingMode 舍入模式
     * @return 返回值
     */
    public static Double round(Double value, Integer scale, Integer roundingMode) {
        Assert.isTrue(scale >= 0, "The scale must be a positive integer or zero");
        return BigDecimal.valueOf(value).setScale(scale, roundingMode).doubleValue();
    }

    /**
     * 截取精度
     *
     * @param value        源值
     * @param scale        精度
     * @param roundingMode 舍入模式
     * @return 返回值
     */
    public static Double round(BigDecimal value, Integer scale, Integer roundingMode) {
        Assert.isTrue(scale >= 0, "The scale must be a positive integer or zero");
        return value.setScale(scale, roundingMode).doubleValue();
    }

    /**
     * 截取精度
     *
     * @param value        源值
     * @param scale        精度
     * @param roundingMode 舍入模式
     * @return 返回值
     */
    public static Double round(String value, Integer scale, Integer roundingMode) {
        Assert.isTrue(scale >= 0, "The scale must be a positive integer or zero");
        return new BigDecimal(value).setScale(scale, roundingMode).doubleValue();
    }

}
