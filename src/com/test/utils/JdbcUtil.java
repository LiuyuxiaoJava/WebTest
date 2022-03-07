package com.test.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Description: 公共类<br/>
 * Date: 2017年10月16日 <br/>
 * 
 * @author dingP
 * @version
 * @see
 */
public class JdbcUtil {
    private static String driver = null;

    private static String url = null;

    private static String username = null;

    private static String password = null;

    static {
        try {
            // 1、读取.properties文件数据
            Properties props = new Properties();
            InputStream ins = JdbcUtil.class.getClassLoader().getResourceAsStream("database.properties");
            props.load(ins);
            // 2、动态获取.properties配置文件中的数据
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");
            // 3、加载驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 
     * Description: 获取连接<br/>
     *
     * @author dingP
     * @return
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
