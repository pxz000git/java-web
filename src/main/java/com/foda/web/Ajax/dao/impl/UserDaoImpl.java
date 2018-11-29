package com.foda.web.Ajax.dao.impl;

import com.foda.web.Ajax.dao.UserDao;
import com.foda.web.Ajax.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * @author pxz
 * @date 2018/11/29 0029-上午 10:54
 */
public class UserDaoImpl implements UserDao{

    public boolean checkUser(String username) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

        String sql = "select count(*) from user where username=?";
        Long result = (Long) runner.query(sql, new ScalarHandler(), username);

        return result > 0;
    }
}
