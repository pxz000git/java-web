package com.foda.web.servlet.filter.auto_login.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author pxz
 * @ date 2018/12/6 0006-下午 5:37
 */
public class MyEntity {
    public static List<User> getUser() {
        ArrayList<User> list = new ArrayList<User>();
        User user1 = new User("zhangsan1","abc1");
        User user2 = new User("zhangsan2","abc2");
        User user3 = new User("zhangsan3","abc3");
        User user4 = new User("zhangsan4","abc4");
        User user5 = new User("zhangsan5","abc5");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        return list;
    }
}
