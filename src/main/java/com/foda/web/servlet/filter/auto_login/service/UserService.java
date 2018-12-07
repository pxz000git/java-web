package com.foda.web.servlet.filter.auto_login.service;

import com.foda.web.servlet.filter.auto_login.domain.User;

/**
 * @ author pxz
 * @ date 2018/12/6 0006-下午 6:16
 */
public interface UserService {
    public User login(String username,String password);
}
