package com.jy.factory;

import com.jy.proxy.User;

public class UserServiceImpl implements UserService{
    @Override
    public void login(String name, String password) {
        System.out.println("UserServiceImpl.login");
    }

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }
}
