package com.foda.web.servlet.filter.auto_login.dao;

import com.foda.web.servlet.filter.auto_login.domain.User;

/**
 * @ author pxz
 * @ date 2018/12/6 0006-下午 5:51
 */
public interface UserDao {
    /**
     * 获用户数据
     * @param username username
     * @param password password
     * @return User
     */
    User getUser(String username,String password);
}
