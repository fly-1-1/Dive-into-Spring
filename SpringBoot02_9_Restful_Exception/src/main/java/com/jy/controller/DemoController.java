package com.jy.controller;


import com.jy.exception.IllegalNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("demo")
@RestController
//@CrossOrigin 局部跨域
public class DemoController {

    @GetMapping
    public ResponseEntity<String> demo() {
        System.out.println("demo ok");
        //int i = 1 / 0;
        return new ResponseEntity<>("demo ok", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> demo(@PathVariable("id") Integer id) {
        System.out.println("demo ok :" + id);
        if (id<0)throw new IllegalNumberException("无效id");
        return new ResponseEntity<>("demo ok", HttpStatus.OK);
    }

}
