package com.jy.config;

import cn.hutool.core.util.ObjectUtil;
import com.jy.entity.Role;
import com.jy.entity.User;
import com.jy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.loadUserByUsername(username);
        if (ObjectUtil.isEmpty(user)) throw new UsernameNotFoundException("用户不存在");
        //select Authority
        List<Role> roles = userMapper.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;

    }
}
