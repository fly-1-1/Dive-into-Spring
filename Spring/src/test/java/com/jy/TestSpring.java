package com.jy;

import com.jy.basic.*;

import org.junit.Test;

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



}
