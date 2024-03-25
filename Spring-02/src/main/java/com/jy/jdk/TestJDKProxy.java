package com.jy.jdk;

import com.jy.proxy.User;
import com.jy.proxy.a.UserService;
import com.jy.proxy.a.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {
    public static void main(String[] args) {
        //创建原始对象
        UserServiceImpl userService = new UserServiceImpl();
        //JDK创建动态代理
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("--proxy log--");
                //原始方法运行
                Object ret = method.invoke(userService, args);
                return ret;
            }
        });

        userServiceProxy.login("zs", "123");
    }
}
