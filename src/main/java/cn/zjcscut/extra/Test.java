package cn.zjcscut.extra;

/**
 * @author zhangjinci
 * @version 2016/7/12 14:23
 */
public class Test {

    public static void main(String[] args){
         ConcurrentHashSet<String> s = new ConcurrentHashSet<>();
         s.add("zjc");
         s.add("zzzzz");
        System.out.println("HashSet to Array -- > " + s.toString());
    }
}
