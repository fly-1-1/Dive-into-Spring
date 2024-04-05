package com.jy.controller;

import com.jy.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("demo")
public class DemoUserController {

    private static final Logger log = LoggerFactory.getLogger(DemoUserController.class);

    @RequestMapping("findUserById")
    public String findUserById(Integer id) {

        log.info("查询用户 {} ", id);
        User user = new User(1, "zx", 1222.00, new Date());
        return "showOne";
    }

    @RequestMapping("findAll")
    public String findAll() {

        log.info("查询所有 ");
        List<User> userList=new ArrayList<User>();
        userList.add(new User(1,"zx",1222.00,new Date()));
        return "showAll";
    }

    @RequestMapping("save")
    public String save(User user) {
        log.info("user:{}",user);
        return "redirect:/user/findAll";
    }

    @RequestMapping("update")
    public String update(User user) {
        log.info("user:{}",user);
        return "redirect:/user/findAll";
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        log.info("删除用户id:{}",id);
        return "redirect:/user/findAll";
    }

}
