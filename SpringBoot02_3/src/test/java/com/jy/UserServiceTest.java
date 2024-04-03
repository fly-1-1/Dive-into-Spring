package com.jy;

import com.jy.entity.User;
import com.jy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserServiceTest extends BasicTest{


    @Autowired
    private UserService userService;

    @Test
    public void Test01(){
        userService.findAll().forEach(s-> System.out.println(s.toString()));
    }

    @Test
    public void Test02(){
        User user = User.builder().name("小白").birthday(new Date()).salary(1000.00).build();
        userService.saveUser(user);
    }
}
