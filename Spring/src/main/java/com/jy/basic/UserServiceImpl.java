package com.jy.basic;

public class UserServiceImpl implements UserService {


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

    }

    @Override
    public void login(String name, String password) {
        userDao.queryUserByNameAndPassWord(name, password);
    }
}
