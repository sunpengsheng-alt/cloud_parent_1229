package com.czxy.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "oid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    @Column(name = "ordertime")
    private Date ordertime;   // 下单时间

    @Column(name = "total")
    private Double total;

    @Column(name = "address")
    private String address;    // 地址

    @Column(name = "`name`")
    private String name;      // 收件人姓名

    @Column(name = "telephone")
    private String telephone;   // 收件人电话

    private List<Long> plist;
}