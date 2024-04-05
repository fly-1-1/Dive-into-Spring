package com.jy.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public void save(String name) {
        System.out.println("UserServiceImpl.save");
    }

    @Override
    public void delete(Integer id) {
        System.out.println("UserServiceImpl.delete");
    }

    @Override
    public void update(String name) {
        System.out.println("UserServiceImpl.update");
    }

    @Override
    public String find(String name) {
        //System.out.println("UserServiceImpl.find");
        return name;
    }
}
