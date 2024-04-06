package com.jy.service;

import com.jy.entity.User;

public interface UserService {

    public void register(User user);


    User login(String username, String password);

}
