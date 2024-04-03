package com.jy.springboot02_1.controller;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Setter
@Getter
@ConfigurationProperties(prefix = "orders")
public class InjectionObjectController {


    private String name;
    private Integer id;


    @RequestMapping("injectObject")
    public String injectObject(){
        System.out.println("id = " + id);
        System.out.println("name = " + name);

        return "injectObject";
    }

}
