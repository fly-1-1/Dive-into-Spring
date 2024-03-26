package com.jy.aspect;

import com.jy.proxy.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectProxy {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        //userService.login("zs","123");
        userService.register(new User("123","123"));
    }
}
