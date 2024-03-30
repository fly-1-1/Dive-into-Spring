package com.jy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FirstController {

    @RequestMapping("/first")
    public String first(HttpServletRequest request, HttpServletResponse response){
        System.out.println("FirstController.first");
        return "/result.jsp";
    }
}
