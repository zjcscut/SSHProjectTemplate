package cn.pp;

import cn.ppfix.entity.User;
import cn.util.json.FastJsonUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author zhangjinci
 * @version 2016/6/23 17:32
 */
public class TestUnSpring {

    @Test
    public void Test1() {
        String[] s = {"<alert sss>", "<><>"};
        String ss = Arrays.toString(s);
        String sss = ss.substring(1, ss.length() - 1);
        String[] ssss = sss.split(",");
        System.out.println("sss[0]-->" + ssss[0] + " sss[1]-->" + ssss[1]);
    }

    @Test
    public void Test2() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zjc");
        map.put("id", 1);
        map.put("date", new Date());
        String s = FastJsonUtils.toJson(map, "yyyy-MM-dd HH:mm:ss");
        System.out.println("map->str:" + s);
        map = FastJsonUtils.toMap(s);
        System.out.println("str->map:" + map);
    }

    @Test
    public void Test3() {
        User user = new User(1, "zjc");
        String s = FastJsonUtils.toJson(user);
        System.out.println("user->str:" + s);
        user = FastJsonUtils.toBean(s, User.class);
        System.out.println("str->user:" + user);
    }

    @Test
    public void Test4() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "zjc1"));
        list.add(null);
        String s = FastJsonUtils.toJson(list);
        System.out.println("list->str:" + s);
        list = FastJsonUtils.toBeanList(s,User.class);
        System.out.println("str->list:"+list.size());
        for (User u : list){
            System.out.println(u);
        }

    }
}
