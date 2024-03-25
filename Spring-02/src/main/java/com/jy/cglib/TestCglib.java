package com.jy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCglib {

    public static void main(String[] args) {
        UserService userService=new UserService();

        //通过cglib方式动态创建代理对象
        Enhancer enhancer=new Enhancer();
        enhancer.setClassLoader(TestCglib.class.getClassLoader());
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("---cglib log---");
                Object ret = method.invoke(userService, args);
                return ret;
            }
        });

        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("123","123");
    }

}
