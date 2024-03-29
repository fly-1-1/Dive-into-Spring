package com.jy.bean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryBean implements FactoryBean<Connection> {


    @Override
    public Connection getObject() throws Exception {
        Connection conn =null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
