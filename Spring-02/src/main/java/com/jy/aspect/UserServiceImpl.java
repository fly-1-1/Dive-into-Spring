package com.jy.aspect;

import com.jy.proxy.User;

public class UserServiceImpl implements UserService{
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public void login(String name, String password) {
        System.out.println("UserServiceImpl.login");
    }
}
