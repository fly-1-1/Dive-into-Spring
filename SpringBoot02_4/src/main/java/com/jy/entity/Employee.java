package com.jy.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Employee  {


    private Integer id;
    private String name;
    //springboot springmvc spring 默认处理日期格式: yyyy/MM/dd HH:mm:ss
    //@DateTimeFormat(pattern = "yyyy-MM-dd") 修改指定日期格式
    private Date birthday;
    private Double salary;
    private Boolean gender;


}
