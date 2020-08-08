package com.czxy.domain;

import lombok.Data;

@Data
public class User {
    private Long uid;

    private String username;

    private String password;
}