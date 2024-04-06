package com.jy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jy.mapper")
public class SpringBoot029RestfulExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot029RestfulExceptionApplication.class, args);
    }

}
