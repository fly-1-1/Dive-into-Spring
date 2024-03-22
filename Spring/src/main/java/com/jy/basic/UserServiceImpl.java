package com.jy.basic;

public class UserServiceImpl implements UserService {


    private UserDao userDao =(UserDao) BeanFactory.getBean("userDao");

    @Override
    public void register(User user) {
       userDao.save(user);

    }

    @Override
    public void login(String name, String password) {
        userDao.queryUserByNameAndPassWord(name, password);
    }
}
