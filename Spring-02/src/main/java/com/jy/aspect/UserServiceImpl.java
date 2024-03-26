package com.jy.aspect;

import com.jy.proxy.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserServiceImpl implements UserService, ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
        //调用原始类的login方法
        //this.login("zs", "123");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("zs","123");

    }

    @Override
    public void login(String name, String password) {
        System.out.println("UserServiceImpl.login");
    }
}
