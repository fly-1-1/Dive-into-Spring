package com.jy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@Configuration
//@ComponentScan(basePackages = "com.jy.scan",excludeFilters =
//        {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Service.class}),
//         @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "*..User1")})
@ComponentScan(basePackages = "com.jy.scan",
useDefaultFilters = false,
includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Service.class})})
/*ASSIGNABLE_TYPE 基于类型 ASPECTJ切入点表达式*/
public class AppConfig2 {

}
