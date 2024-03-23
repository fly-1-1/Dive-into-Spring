package com.jy;

import com.jy.basic.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {


    /**
     * 测试工厂类用于解耦合操作
     */
    @Test
    public void test1(){
        //UserService userService = new UserServiceImpl();
        UserService userService = (UserService) BeanFactory.getBean("userService");

        userService.login("name","suns");

        User user=new User("suns","123456");

        userService.register(user);
    }

    @Test
    public void test2(){
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println(person);
    }

    /**
     * 测试Spring第一个程序
     */
    @Test
    public void test3(){
       //获得Spring工厂
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
        //通过工厂类 获得 对象
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }



}
