package com.jy.service;

import com.jy.entity.User;

import java.util.List;

public interface UserService  {

    public List<User> findAll();

    public void saveUser(User user);

}
