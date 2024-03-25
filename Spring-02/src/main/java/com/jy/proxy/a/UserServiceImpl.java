package com.jy.proxy.a;

import com.jy.Log;
import com.jy.proxy.User;

public class UserServiceImpl implements UserService {

    @Log
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算+Dao");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
