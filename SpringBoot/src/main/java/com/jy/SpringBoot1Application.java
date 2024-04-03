package com.jy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//用在入口类上 标志springboot入口类
//组个注解: 多个注解组合而成的注解
//元注解: 修饰注解的注解
//SpringBootConfiguration : 自动配置Spring SpringMvc相关环境
// +EnableAutoConfiguration : 开启自动配置 自动配置核心注解核心注解
// 自动配置Spring相关环境 自动与项目中 引入第三方技术自动配置环境
// +ComponentScan : 组件扫描 根据注解发挥注解作用 默认扫描当前包及其子包
@SpringBootApplication
public class SpringBoot1Application {

    public static void main(String[] args) {
        //参数1 指定入口类的类对象.class 参数二main函数的参数
        SpringApplication.run(SpringBoot1Application.class, args);
    }
}
