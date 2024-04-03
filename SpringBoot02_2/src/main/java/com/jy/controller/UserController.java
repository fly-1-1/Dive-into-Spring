package com.jy.controller;


import com.jy.entity.User;
import com.jy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @RequestMapping("findAll")
    public List<User> findAll(){
       return userService.findAll();
    }

    @RequestMapping("save")
    public void saveUser(User user){
       userService.saveUser(user);
    }

}
