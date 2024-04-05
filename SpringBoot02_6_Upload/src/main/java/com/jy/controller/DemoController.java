package com.jy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("demo")
    public String demo(){
        System.out.println("DemoController.demo");
        return "demo";
    }

}
