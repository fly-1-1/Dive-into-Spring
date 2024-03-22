package com.jy.basic;

public class UserDaoImpl implements UserDao{
    @Override
    public void save(User user) {
        System.out.println("insert into user = " + user);
    }

    @Override
    public void queryUserByNameAndPassWord(String name, String password) {
        System.out.println("query User name = " + name + " password = " + password);
    }
}
