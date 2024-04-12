package com.jy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jy.config")
public class SpringSecurity08RemembermeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity08RemembermeApplication.class, args);
    }

}
