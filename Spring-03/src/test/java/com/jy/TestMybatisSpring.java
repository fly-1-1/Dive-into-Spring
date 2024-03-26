package com.jy;

import com.jy.dao.UserDao;
import com.jy.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMybatisSpring {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");

        userDao.save(new User("lisi","123"));
    }
}
