package com.jy;

import com.jy.bean.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

public class TestAnnotation {

    @Test
   public void test01(){
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.jy");
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //User user = (User) ctx.getBean("user");
        Connection conn = (Connection) ctx.getBean("conn1");

    }
}
