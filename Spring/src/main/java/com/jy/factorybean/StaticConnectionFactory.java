package com.jy.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StaticConnectionFactory {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
