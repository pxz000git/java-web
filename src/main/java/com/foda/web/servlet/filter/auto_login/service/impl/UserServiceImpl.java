package com.foda.web.servlet.filter.auto_login.service.impl;

import com.foda.web.servlet.filter.auto_login.domain.User;
import com.foda.web.servlet.filter.auto_login.dao.UserDao;
import com.foda.web.servlet.filter.auto_login.dao.impl.UserDaoImpl;
import com.foda.web.servlet.filter.auto_login.service.UserService;

/**
 * @ author pxz
 * @ date 2018/12/6 0006-下午 6:16
 */
public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();
    public User login(String username, String password) {

        //数据库取值
        User user = dao.getUser(username, password);

        if(user != null){
            return user;
        }
        return null;
    }
}
