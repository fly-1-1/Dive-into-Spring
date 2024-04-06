package com.jy;

import com.jy.entity.User;
import com.jy.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot029RestfulExceptionApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        User user = userMapper.selectById(3);
        System.out.println(user);
    }

}
