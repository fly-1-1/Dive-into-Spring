package com.jy.service;

import com.jy.entity.User;

public interface UserService {
    public void register(User user);

    public void login(String name,String password);
}
