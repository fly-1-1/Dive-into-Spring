package com.jy.proxy;

public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算+Dao");
    }

    @Override
    public boolean login(String name, String password) {
        return true;
    }
}
