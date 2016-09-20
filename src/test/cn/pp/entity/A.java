/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.pp.entity;

/**
 * @author zhangjinci
 * @version 2016/9/19 18:57
 * @function
 */
public class A {

    public static final String ss = "ss";

    private Integer id;
    private String name;

    public A(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public A() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String me(String c){
        System.out.println("cccc==>" +c);
        return c;
    }
}
