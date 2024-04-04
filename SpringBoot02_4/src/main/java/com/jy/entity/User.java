package com.jy.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String realname;
    private String password;
    private Boolean gender;


}
