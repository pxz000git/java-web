package com.foda.web.Ajax.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;
import java.util.Properties;

/**
 * @author pxz
 * @date 2018/11/23 0023-下午 4:20
 */
public class JDBCUtil {
    // 资源
    private static Properties properties = null;
    private static String driverClass = "jdbc.driverClass";
    private static String connectionURL = "jdbc.connectionURL";

    private static String username = "jdbc.username";
    private static String password = "jdbc.password";

    static ComboPooledDataSource dataSource = null;
    static {
        properties = new Properties();
        dataSource = new ComboPooledDataSource();
    }

    public static ComboPooledDataSource getDataSource() {
        return dataSource;
    }
    /*static {

        try {
            // 创建属性配置对象
           properties = new Properties();
            //项目下
            //InputStream source = new FileInputStream("./src/main/resources/jdbc.properties");
            InputStream source = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

            //导入输入流
            properties.load(source);

            //读取属性
            driverClass = properties.getProperty(driverClass);
            connectionURL = properties.getProperty(connectionURL);
            username = properties.getProperty(username);
            password = properties.getProperty(password);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 获取连接
     *
     * @return connection
     */
    public static Connection getConn() {
        Connection connection = null;
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(connectionURL, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * 释放资源
     *
     * @param connection connection
     * @param statement  statement
     * @param resultSet  resultSet
     */
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {

        close(resultSet);
        close(statement);
        close(connection);
    }
    public static void release(Connection connection, Statement statement) {

        close(statement);
        close(connection);
    }
    public static void release(Connection connection, PreparedStatement preparedStatement) {

        close(preparedStatement);
        close(connection);
    }

    /**
     * 释放连接
     *
     * @param connection connection
     */
    private static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放句柄
     *
     * @param prepareStatement
     */
    private static void close(PreparedStatement prepareStatement) {
        if (prepareStatement != null) {
            try {
                prepareStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放结果集
     *
     * @param resultSet
     */
    private static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
