package com.jy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jy.mapper")
public class SpringSecurity16AuthorizeDynamicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity16AuthorizeDynamicApplication.class, args);
	}

}
