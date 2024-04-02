package com.jy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view4")
public class View4Controller {

    @RequestMapping("/view1")
    public String view1(@ModelAttribute("name")String name){
        System.out.println("name = " + name);
        return "result3";
    }



}
