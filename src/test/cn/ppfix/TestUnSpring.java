package cn.ppfix;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangjinci
 * @version 2016/6/23 17:32
 */
public class TestUnSpring {

    @Test
    public void Test1(){
        String[] s = {"<alert sss>","<><>"};
        String ss = Arrays.toString(s);
        String sss = ss.substring(1,ss.length() -1);
        String[] ssss =  sss.split(",");
        System.out.println("sss[0]-->" + ssss[0] + " sss[1]-->" + ssss[1]);
    }
}
