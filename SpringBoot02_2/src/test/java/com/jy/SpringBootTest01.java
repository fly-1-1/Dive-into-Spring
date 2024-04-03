package com.jy;

import com.jy.entity.User;
import com.jy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SpringBootTest01 {

    @Autowired
    private  UserService userService;

    @Test
    public void Test01(){
        userService.findAll().forEach(s-> System.out.println(s.toString()));
    }

}
