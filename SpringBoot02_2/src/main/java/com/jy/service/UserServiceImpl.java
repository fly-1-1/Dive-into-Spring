package com.jy.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.jy.entity.User;
import com.jy.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static cn.hutool.core.util.ReUtil.findAll;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    //private final UserMapper userMapper;

    @Override
    public List<User> findAll() {
        //BaseMapper
        //LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>().select(User::getId, User::getName, User::getBirthday, User::getSalary);
        //return userMapper.selectList(wrapper);

        //静态Db
        //return Db.list(User.class);

        //ServiceImpl
        return list();

    }

    public void saveUser(User user){
        save(user);
        throw new RuntimeException();
    }
}
