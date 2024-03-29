package com.jy;

import com.jy.bean.ConnectionFactoryBean;
import com.jy.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    /*简单对象*/
    @Bean
    public User user() {
        return new User();
    }

    /*复杂对象*/
    @Bean
    @Scope("prototype")
    public Connection conn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    @Bean
    public Connection conn1() {
        ConnectionFactoryBean factoryBean = new ConnectionFactoryBean();
        Connection conn = null;
        try {
            conn = factoryBean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

}
