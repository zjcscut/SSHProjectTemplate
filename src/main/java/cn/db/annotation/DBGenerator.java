/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.db.annotation;


import java.lang.reflect.Field;

/**
 * @author zhangjinci
 * @version 2016/8/22 9:15
 * @function 根据PO生成表创建sql,根据read方法上的注解，生成数据库字段信息，没有read方法的Field跳过
 * @since jdk1.8
 */
public interface DBGenerator {

    String generate(Class clazz);

    String generateFields(Class clazz, StringBuilder sb, Field[] fields,int maxLength);

    void generatePrimaryKey(StringBuilder sb,String tableName,String primaryKey);

    int getMaxLength(Class clazz,Field[] fields);

}
