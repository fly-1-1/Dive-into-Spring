package com.jy.dao;

import com.opensymphony.xwork2.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    //@Resource
    //@Inject
    private UserDao userDao;

    public UserDao getDao() {
        return userDao;
    }

//    @Autowired
//    public void setDao(UserDao dao) {
//        this.userDao = dao;
//    }

    @Override
    public void register() {
        userDao.save();

    }
}
