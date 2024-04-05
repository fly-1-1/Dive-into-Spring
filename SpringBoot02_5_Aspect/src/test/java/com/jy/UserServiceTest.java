package com.jy;

import com.jy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest{


    @Autowired
    private UserService userService;

    @Test
    public void test(){
        String string = userService.find("Jack");
        System.out.println("name:"+string);
    }

}
