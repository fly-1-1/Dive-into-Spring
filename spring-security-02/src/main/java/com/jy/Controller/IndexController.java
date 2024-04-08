package com.jy.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("index")
    public String index() {
        System.out.println("IndexController.index");
        return "index";
    }

    //获取多个用户
    @RequestMapping("users")
    public String users() {
        System.out.println("IndexController.users");
        //查询数据库获取用户列表

        return "users";
    }

}
