package com.foda.web.servlet.filter.auto_login.dao.impl;

import com.foda.web.servlet.filter.auto_login.domain.MyEntity;
import com.foda.web.servlet.filter.auto_login.domain.User;
import com.foda.web.servlet.filter.auto_login.dao.UserDao;

import java.util.List;

/**
 * @ author pxz
 * @ date 2018/12/6 0006-下午 6:38
 */
public class UserDaoImpl implements UserDao {
    public User getUser(String username, String password) {
        List<User> users = MyEntity.getUser();
        User user = new User();
        String name;
        String pwd;
        for (User user1 : users) {
            name = user1.getUsername();
            pwd = user1.getPassword();
            if (username.equals(name)) {
                if (password.equals(pwd)) {
                    user.setUsername(name);
                    user.setPassword(pwd);
                    return user;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        User user = new UserDaoImpl().getUser("zhangsan1", "abc1");
        System.out.println(user);
    }
}
