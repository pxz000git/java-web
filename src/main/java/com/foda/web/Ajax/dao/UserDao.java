package com.foda.web.Ajax.dao;

import java.sql.SQLException;

/**
 * @author pxz
 * @date 2018/11/29 0029-上午 10:51
 */
public interface UserDao {
    //校验用户名是否存在
    public boolean checkUser(String username) throws SQLException;
}
