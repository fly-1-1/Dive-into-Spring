package com.jy.basic;

public interface UserDao {
    void save(User user);

    void queryUserByNameAndPassWord(String name, String password);
}
