package com.jy.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {

    private static Properties env = new Properties();

    static {
        InputStream inputStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties");
        try {
            env.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static UserService getUserService() {
//        UserService userService = null;
//        try {
//            Class clazz = Class.forName(env.getProperty("userService"));
//            userService = (UserService) clazz.newInstance();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//        return userService;
//    }
//
//    public static UserDao getUserDao() {
//        UserDao userDao = new UserDaoImpl();
//        try {
//            Class clazz = Class.forName(env.getProperty("userDao"));
//            userDao = (UserDao) clazz.newInstance();
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        return userDao;
//    }

    public static Object getBean(String key) {
        Object ret = null;
        try {
            Class clazz = Class.forName(env.getProperty(key));
            ret = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

}
