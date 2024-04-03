package com.jy.springboot02_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Configuration //修饰范围 只可以用在类上
public class BeanConfig {

    @Bean //修饰范围:方法或者注解上 作用:将方法返回值交给Spring工厂
    public Calendar calendar(){
        return Calendar.getInstance();
    }

}
