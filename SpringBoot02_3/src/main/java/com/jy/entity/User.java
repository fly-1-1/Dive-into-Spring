package com.jy.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class User implements Serializable {
    private Integer id;
    private String name;
    private Date birthday;
    private Double salary;
}
