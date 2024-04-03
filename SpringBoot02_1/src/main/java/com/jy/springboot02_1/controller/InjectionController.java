package com.jy.springboot02_1.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class InjectionController {

    @Value("${name}")
    private String name;

    @Value("${birthday}")
    private Date birthday;

    @Value("${qqs}")
    private String []qqs;

    @Value("${lists}")
    private List<String> lists;

    @Value("#{${maps}}")
    private Map<String,String>maps;



    @RequestMapping("inject")
    public String inject(){
        System.out.println("InjectionController.inject");
        System.out.println("name = " + name);
        System.out.println("birthday = " + birthday);
        for (String qq : qqs) {
            System.out.println(qq);
        }
        for (String list : lists) {
            System.out.println(list);
        }

        maps.forEach((k,v)->{
            System.out.println("k:"+k+" v:"+v);
        });
        return "inject";
    }
}
