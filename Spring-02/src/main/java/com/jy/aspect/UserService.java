package com.jy.aspect;

import com.jy.proxy.User;

public interface UserService {

    public void register(User user);

    public void login(String name,String password);



}
