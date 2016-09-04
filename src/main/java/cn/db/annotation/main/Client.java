/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.db.annotation.main;

import cn.db.annotation.DBGenerator;
import cn.db.annotation.impl.DBGeneratorImpl;

/**
 * @author zhangjinci
 * @version 2016/8/22 10:23
 * @function
 */
public class Client {

    public static void main(String[] args){
        DBGenerator dbGenerator = new DBGeneratorImpl();
        System.out.println(dbGenerator.generate(User.class));
    }
}
