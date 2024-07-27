package com.StuentManagerSys;
// package main.java.com.StuentManagerSys.util;
// package com.StuentManagerSys.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Properties;

public class DatabaseUtil {
    public static Connection getConnection() throws SQLException{
        Properties props = new Properties();
        try {
            props.load(DatabaseUtil.class.getClassLoader().getResourceAsStream("database.properties"));
        } catch (Exception e) {
            throw new SQLException("Cannot load database properties", e);
        }
        // TODO: Implement the connection logic using the properties
        String driver = props.getProperty("driver_name");
        String url = props.getProperty("db_url");
        String user = props.getProperty("db_user");
        String password = props.getProperty("db_password");

        try {
            if (driver != null && url != null && user != null && password != null) {
                Class.forName(driver);
                return java.sql.DriverManager.getConnection(url, user, password);
            }
        } catch (Exception e) {
            throw new SQLException("Cannot make the connection with database", e);
        }
        return null;
    }
}
