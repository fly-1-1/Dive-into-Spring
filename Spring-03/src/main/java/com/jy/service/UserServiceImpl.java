package com.jy.service;

import com.jy.entity.User;
import com.jy.dao.UserDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/*
*propagation = Propagation.REQUIRED  增删改操作需要 外有无->开 有->融合 默认值
*propagation = Propagation.SUPPORTS   查询需要      外无->不开 有->融合
*Propagation.REQUIRES_NEW 日志需要 外无->开 暂停外部事物
*/
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        userDao.save(user);
        throw new RuntimeException("测试");
    }

    /*
    * 针对查询操作业务，提供运行效率
    * */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void login(String name, String password) {

    }
}
