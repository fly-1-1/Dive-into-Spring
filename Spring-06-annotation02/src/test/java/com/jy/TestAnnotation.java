package com.jy;

import com.jy.aop.UserService;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

public class TestAnnotation {

    @Test
    public void test01() {
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.jy");
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //User user = (User) ctx.getBean("user");
        Connection conn = (Connection) ctx.getBean("conn1");

    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }


    @Test
    public void test04() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(com.jy.aop.AppConfig.class);
        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        userService.login();
        userService.register();


    }
}
