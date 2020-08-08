package com.czxy.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "cid")
    private Long cid;

    @Column(name = "cname")
    private String cname;
}