/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.db.annotation.impl;

import cn.db.annotation.DBGenerator;
import cn.db.annotation.anno.Column;
import cn.db.annotation.anno.Id;
import cn.db.annotation.anno.Table;
import cn.db.annotation.converter.DataBases;
import cn.db.annotation.converter.MysqlTypeContainer;
import cn.db.annotation.exception.CustomException;
import org.apache.commons.lang3.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/8/22 9:44
 * @function
 */
public class DBGeneratorImpl implements DBGenerator {

    private Map<Class<?>, String> converter;

    /**
     * 根据类的注解信息生成表sql
     *
     * @param clazz
     * @return
     */
    @Override
    public String generate(Class clazz, DataBases dataBases) {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new CustomException("No Annotation[Table] founded in class[" + clazz.getName() + "]", "-1");
        }

        Table table = (Table) clazz.getAnnotation(Table.class);
        String tableName = table.value();
        if (StringUtils.isBlank(tableName)) {
            tableName = table.name();
        }
        StringBuilder sb = new StringBuilder("-- CREATE TABLE\n");
        sb.append("CREATE TABLE ").append(tableName).append("\n");
        sb.append("(\n");
        Field[] fields = clazz.getDeclaredFields();
        int maxLength = getMaxLength(clazz, fields);
        String primaryKey = generateFields(clazz, sb, fields, maxLength);
        sb.append(");\n");
        generatePrimaryKey(sb, tableName, primaryKey);
        return sb.toString();
    }

    /**
     * 生成sql字段
     *
     * @param clazz
     * @param sb
     * @param maxLength
     * @return
     */
    @Override
    public String generateFields(Class clazz, StringBuilder sb, Field[] fields, int maxLength) {
        String primaryKey = "";
        Field field;
        for (int i = 0; i < fields.length; i++) {
            field = fields[i];
            int offset;
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz); //对getter和setter进行处理
                Method md = pd.getReadMethod();
                if (null != md) {
                    Column col = md.getAnnotation(Column.class);
                    writeBlankSpace(sb, 2);  //输出两个空格
                    sb.append(col.name()); //写入行名称
                    offset = maxLength - col.name().length();  //获取字段名称的最大长度,用于控制格式
                    writeBlankSpace(sb, offset);
                    writeBlankSpace(sb, 1);
                    sb.append(convertJavaToMysql(field, col)); //转化为Oracle字段形式(这里最好加入多种数据库的转换逻辑)
                    if (md.isAnnotationPresent(Id.class)) {
                        sb.append(" not null");
                        primaryKey = col.name();
                    } else if (col.nullable()) {
                        sb.append(" not null");
                    }
                }
            } catch (IntrospectionException e) {
                //找不到readMethod,跳过(找不到getter方法)
                continue;
            }

            if (i != (fields.length - 1)) {
                sb.append(",");
            }
            sb.append("\n");
        }
        return primaryKey;
    }

    @Override
    public void generatePrimaryKey(StringBuilder sb, String tableName, String primaryKey) {
        if (StringUtils.isNotBlank(primaryKey)) {
            sb.append("ALTER TABLE " + tableName + "\n");
            sb.append("  ADD PRIMARY KEY (" + primaryKey + ")\n");
            sb.append("  USING INDEX;");
        }
    }

    @Override
    public int getMaxLength(Class clazz, Field[] fields) {
        Field field;
        int maxLength = 0;
        for (int i = 0; i < fields.length; i++) {
            field = fields[i];
            PropertyDescriptor pd;
            try {
                pd = new PropertyDescriptor(field.getName(), clazz);
                Method mt = pd.getReadMethod();
                if (null != mt) {
                    if (!mt.isAnnotationPresent(Column.class)) {
                        throw new CustomException("No Annotation[Column] founded in Method[" + mt.getName() + "]", "-1");
                    }
                    Column col = mt.getAnnotation(Column.class);
                    int temLength = col.name().length();
                    if (temLength > maxLength) {
                        maxLength = temLength;
                    }
                }
            } catch (IntrospectionException e) {
                //找不到readMethod,跳过
                //throw new RuntimeException("No " + field.getName() + "'s ReadMethod founded in class["+clazz.getName()+"]");
                continue;
            }
        }
        return maxLength;
    }

    /**
     * 将java类型转换为orable类型
     *
     * @param field
     * @param col
     * @return
     */
    private String convertJavaToOracle(Field field, Column col) {

        //TODO 此处可根据自己需要做类型转换
        String type = "VARCHAR2";
        if (field.getType().equals(String.class)) {
            type = "VARCHAR2(" + col.length() + ")";
        } else if (field.getType().equals(java.util.Date.class) || field.getType().equals(java.sql.Date.class)) {
            type = "DATE";
        } else if (field.getType().equals(Integer.class)) {
            type = "NUMBER";
        }
        return type;
    }

    /**
     * mysql字段类型转换(这里可以写成一个接口)
     *
     * @param field
     * @param col
     * @return
     */
    private String convertJavaToMysql(Field field, Column col) {

        String type = "";
        converter = MysqlTypeContainer.getContainer();

        if (converter.containsKey(field.getType())) {
            type = converter.get(field.getType());
            if ((String.class).equals(field.getType())) {
                type += "(" + col.length() + ")";
            }
        }
        return type;
    }

    /**
     * 输出空格
     *
     * @param sb
     * @param n
     */
    private void writeBlankSpace(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
    }

    /**
     * 设置编码
     *
     * @param sb
     * @param charSet
     * @return
     */
    private String setCharSet(StringBuilder sb, String charSet) {
        if (StringUtils.isNotBlank(charSet)) {
            sb.append("DEFAULT CHARSET=").append(charSet);
            writeBlankSpace(sb, 1);
        }
        return sb.toString();
    }

    /**
     * 设置校对规则
     *
     * @param sb
     * @param collation
     * @return
     */
    private String setCollation(StringBuilder sb, String collation) {
        if (StringUtils.isNotBlank(collation)) {
            sb.append("COLLATE=").append(collation);
            writeBlankSpace(sb, 1);
        }
        return sb.toString();
    }

    /**
     * 设置数据库引擎
     *
     * @param sb
     * @param engine
     * @return
     */
    private String setEngine(StringBuilder sb, String engine, String dbName) {
        if (dbName.equalsIgnoreCase(DataBases.MYSQL.name())) {
            sb.append("ENGINE=").append(engine);
            writeBlankSpace(sb, 1);
        }
        return sb.toString();
    }

}
