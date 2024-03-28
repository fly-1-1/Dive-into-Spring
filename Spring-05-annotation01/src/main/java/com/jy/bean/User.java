package com.jy.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/*
@Component("u") bean id
配置文件可以覆盖注解
@Component的衍生注解 本质上这些注解就是Component 作用和用法一致
@Repository
@Service
@Controller
目的:为了准确的表达一个类的作用
* */
@Component
public class User implements Serializable {

    private Integer id;
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
