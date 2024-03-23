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
    public void test1() {
        //UserService userService = new UserServiceImpl();
        UserService userService = (UserService) BeanFactory.getBean("userService");

        userService.login("name", "suns");

        User user = new User("suns", "123456");

        userService.register(user);
    }

    @Test
    public void test2() {
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println(person);
    }

    /**
     * 测试Spring第一个程序
     */
    @Test
    public void test3() {
        //获得Spring工厂
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //通过工厂类 获得 对象
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

    /**
     * 测试 Spring工厂提供的其他方法
     */
    @Test
    public void test4() {
        //获得Spring工厂
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //通过工厂类 获得 对象
        //Person person = ctx.getBean("person", Person.class);
        //Person person = ctx.getBean(Person.class);
        //String[] beanDefinitionNames = ctx.getBeanDefinitionNames();

        //根据类型获得Spring配置文件中的对应的id值
        /*String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        for (String id : beanNamesForType) {
            System.out.println(id);
        }*/

        //判断是否有id为person的bean
        /*boolean b = ctx.containsBeanDefinition("person");
        System.out.println(b);*/

        //判断是否有id为person的bean
        /*boolean b = ctx.containsBean("person");
        System.out.println(b);*/
    }


}
