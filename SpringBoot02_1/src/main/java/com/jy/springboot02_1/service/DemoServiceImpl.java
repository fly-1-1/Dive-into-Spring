package com.jy.springboot02_1.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{
    @Override
    public void demo() {
        System.out.println("DemoServiceImpl.demo");
    }
}
