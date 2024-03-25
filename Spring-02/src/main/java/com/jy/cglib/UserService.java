package com.jy.cglib;

import com.jy.Log;
import com.jy.proxy.User;

public class UserService {


    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }


    public void login(String name, String password) {
        System.out.println("UserServiceImpl.login");
    }
}
