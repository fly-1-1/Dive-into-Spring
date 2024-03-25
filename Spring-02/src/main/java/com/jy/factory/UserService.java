package com.jy.factory;

import com.jy.proxy.User;

public interface UserService {
    public void login(String name,String password);

    public void register(User user);
}
