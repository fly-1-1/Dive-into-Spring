package com.jy;

import com.jy.dao.UserDao;
import com.jy.entity.User;
import com.jy.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMybatisSpring {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");

        userDao.save(new User("lisi","123"));
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register(new User("zs1","123"));

    }
}
