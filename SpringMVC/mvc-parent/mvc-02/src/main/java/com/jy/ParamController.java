package com.jy;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("param")
public class ParamController {


    /*简单变量*/
    @RequestMapping("param2")
    public String m2(String name ,String password){
        System.out.println("name = " + name + ", password = " + password);
        return "param1";
    }

    /*简单变量的自动转换*/
    @RequestMapping("param3")
    public String m3(String name ,Integer password){
        System.out.println("name = " + name + ", password = " + password);
        return "param1";
    }

    /*servlet api 接收请求参数*/
    @RequestMapping("param1")
    public String m1(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "param1";
    }
}
