package com.jy.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext1.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("zs","123");

    }
}
