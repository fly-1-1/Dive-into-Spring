package com.jy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//servlet是单实例模式
@Controller
//@Scope("prototype")
public class FirstController {

    public FirstController() {
        System.out.println("FirstController.FirstController");
    }

    /*
     * url起始反斜线可以省略
     *
     */
    @RequestMapping("/first")
    public String first(HttpServletRequest request, HttpServletResponse response){
        System.out.println("FirstController.first");
        return "/result.jsp";
    }

    @RequestMapping(value = "/second")
    public String second(HttpServletRequest request, HttpServletResponse response){
        System.out.println("FirstController.second");
        return "/result.jsp";
    }

    @RequestMapping(value = {"/third1","third2"})
    public String third(HttpServletRequest request, HttpServletResponse response){
        System.out.println("FirstController.third");
        return "/result.jsp";
    }
}
