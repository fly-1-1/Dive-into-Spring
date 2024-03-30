package com.jy;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* @RequestMapping设计目的
* 模块区分各司其职 更好管理
* */

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("addUser")
    public String addUser(){
        System.out.println("UserController.addUser");
        return "/result.jsp";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(){
        System.out.println("UserController.deleteUser");
        return "/result.jsp";
    }

}
