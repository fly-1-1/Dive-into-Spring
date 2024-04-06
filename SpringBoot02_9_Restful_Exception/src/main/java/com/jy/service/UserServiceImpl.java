package com.jy.service;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.entity.User;
import com.jy.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Override
    public void register(User user) {

        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).
                select(User::getUsername).
                eq(User::getUsername, user.getUsername());

        User u = getOne(wrapper,false);
        if (!ObjectUtil.isEmpty(u))throw new RuntimeException("用户名已存在");
        //注册
        String pwd = MD5.create().digestHex(user.getPassword());
        user.setPassword(pwd);
        save(user);
    }

    @Override
    public User login(String username, String password) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).
                select(User::getUsername,User::getPassword,User::getRealname).
                eq(User::getUsername, username);
        User user = getOne(wrapper,false);
        if (ObjectUtil.isEmpty(user))throw new RuntimeException("用户名输入错误");
        String pwd = MD5.create().digestHex(password);
        if (!ObjectUtil.equal(pwd,user.getPassword()))throw  new RuntimeException("密码错误");
        return user;
    }
}
