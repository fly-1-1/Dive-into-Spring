package com.jy.springboot02_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

    @RequestMapping("jsp")
    public String jsp(){

        System.out.println("JspController.jsp");
        return "index";
    }

}
