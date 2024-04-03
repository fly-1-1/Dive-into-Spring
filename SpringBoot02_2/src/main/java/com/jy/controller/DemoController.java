package com.jy.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {




    @RequestMapping("demo")
    public String demo(){
        System.out.println("demo");
       return "demo3";
    }



}
