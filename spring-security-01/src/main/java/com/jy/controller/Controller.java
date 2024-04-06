package com.jy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("hello")
    public String hello(){
        System.out.println("hello security");
        return "hello spring security";
    }



}
