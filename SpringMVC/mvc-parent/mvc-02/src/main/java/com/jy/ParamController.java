package com.jy;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("param")
public class ParamController {

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
