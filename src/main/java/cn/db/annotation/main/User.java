/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.db.annotation.main;

import cn.db.annotation.anno.Column;
import cn.db.annotation.anno.Id;
import cn.db.annotation.anno.Table;

import java.util.Date;

/**
 * @author zhangjinci
 * @version 2016/8/22 10:23
 * @function
 */
@Table("TB_AT_USER")
public class User {

    private Integer id;
    private String name;
    private Date birth;

    public User() {
    }

    public User(Integer id, String name, Date birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    @Id
    @Column(name = "ID",length = 12)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME",nullable = false,length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "BIRTH")
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
