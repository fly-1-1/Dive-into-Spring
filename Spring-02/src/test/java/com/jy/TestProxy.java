package com.jy;

import com.jy.proxy.*;
import org.junit.Test;

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
}
