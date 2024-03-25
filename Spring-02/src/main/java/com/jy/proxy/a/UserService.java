package com.jy.proxy.a;

import com.jy.proxy.User;

public interface UserService {
    void register(User user);

    boolean login(String name, String password);
}
