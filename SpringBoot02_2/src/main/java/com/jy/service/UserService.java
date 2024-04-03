package com.jy.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.entity.User;
import com.jy.mapper.UserMapper;

import java.util.List;

public interface UserService  {

    public List<User> findAll();

    public void saveUser(User user);

}
