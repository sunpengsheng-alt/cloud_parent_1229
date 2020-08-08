package com.czxy.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`user`")
public class User {
    @Id
    @Column(name = "`uid`")
    private Long uid;

    @Column(name = "username")
    private String username;

    @Column(name = "`password`")
    private String password;
}