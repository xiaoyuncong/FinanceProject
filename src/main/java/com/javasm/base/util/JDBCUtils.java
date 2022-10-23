package com.javasm.base.util;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/9/3-9:44
 * @Since：jdk1.8
 * @Description：
 */
public class JDBCUtils {

    private static DruidDataSource druidDataSource;

    static {
        // 读取配置文件，实例化数据源对象
        //  读取配置文件
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        // 实例化properties
        Properties properties = new Properties();
        try {

            // 加载 inputStream ，解析文件
            properties.load(inputStream);

            // 实例化数据源
            druidDataSource = new DruidDataSource();
            // 加载配置
            druidDataSource.configFromPropety(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            return druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 执行增删改
     *
     * @param sql
     * @param params
     * @return
     */
    public static int update(String sql, Object... params) {
        //获取数据库连接
        Connection connection = getConnection();
        if (isConnection(connection)) {
            try {
                return new QueryRunner().update(connection, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbUtils.closeQuietly(connection);
            }
        }
        return 0;
    }

    /**
     * 执行增删改（事务）
     *
     * @param connection
     * @param sql
     * @param params
     * @return
     */
    public static int update(Connection connection, String sql, Object... params) {
        if (isConnection(connection)) {
            try {
                return new QueryRunner().update(connection, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 新增：得到自增id
     *
     * @param sql
     * @param params
     * @return
     */
    public static int insert(String sql, Object... params) {
        //获取数据库连接
        Connection connection = getConnection();
        if (isConnection(connection)) {
            try {
                return new QueryRunner().insert(connection, sql, new ScalarHandler<Long>(), params).intValue();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbUtils.closeQuietly(connection);
            }
        }
        return 0;
    }

    /**
     * 执行新增（事务）
     *
     * @param connection
     * @param sql
     * @param params
     * @return
     */
    public static int insert(Connection connection, String sql, Object... params) {
        if (isConnection(connection)) {
            try {
                return new QueryRunner().insert(connection, sql, new ScalarHandler<Long>(), params).intValue();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 执行查询
     *
     * @param sql
     * @param clazz
     * @param params
     * @param <T>
     * @return 集合
     */
    public static <T> List<T> query(String sql, Class clazz, Object... params) {
        Connection connection = getConnection();
        if (isConnection(connection)) {
            try {
                return new QueryRunner().query(connection, sql, new BeanListHandler<T>(clazz), params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbUtils.closeQuietly(connection);
            }
        }
        return null;
    }

    /**
     * 查询单个对象
     *
     * @param sql
     * @param clazz
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T get(String sql, Class clazz, Object... params) {
        Connection connection = getConnection();
        if (isConnection(connection)) {
            try {
                return new QueryRunner().query(connection, sql, new BeanHandler<T>(clazz), params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbUtils.closeQuietly(connection);
            }
        }
        return null;
    }

    /**
     * 统计条数
     *
     * @param sql
     * @param params
     * @return
     */
    public static int count(String sql, Object... params) {
        //获取数据库连接
        Connection connection = getConnection();
        if (isConnection(connection)) {
            try {
                return new QueryRunner().query(connection, sql, new ScalarHandler<Long>(), params).intValue();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbUtils.closeQuietly(connection);
            }
        }
        return 0;
    }

    /**
     * 数据库连接是否成功？
     *
     * @param connection
     * @return
     */
    private static boolean isConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
