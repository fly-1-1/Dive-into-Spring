package com.jy;

import com.jy.proxy.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {


    /**
     * 测试:静态代理 有一个原始类就有一个代理类
     */
    @Test
    public void Test01(){
        UserService userService=new UserServiceProxy();
        userService.login("zs","123");
        userService.register(new User("zs","123"));

        System.out.println("----------------");

        OrderService orderService=new OrderServiceProxy();
        orderService.showOrder();
    }

    /**
     * 测试:Spring动态代理
     */
    @Test
    public void Test02(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        //userService.login("zs","123");
        userService.register(new User("za","123"));

        /*OrderService orderService = (OrderService) ctx.getBean("orderService");
        orderService.showOrder();*/
    }
}
