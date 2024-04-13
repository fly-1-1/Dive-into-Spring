package com.jy.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin
public class DemoController {


    @GetMapping("/demo")
    //@CrossOrigin(origins = {"http://127.0.0.1:5673"})
    public String demo() {
        return "demo controller!";
    }
}
