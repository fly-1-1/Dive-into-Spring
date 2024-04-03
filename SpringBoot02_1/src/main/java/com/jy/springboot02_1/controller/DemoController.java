package com.jy.springboot02_1.controller;

import com.jy.springboot02_1.service.DemoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final   DemoService demoService;


    private final Calendar calendar;



    @RequestMapping("demo")
    public String demo() {
        demoService.demo();
        System.out.println("DemoController.demo");
        Date time = calendar.getTime();
        System.out.println("time = " + time);
        return "demo";
    }
}
