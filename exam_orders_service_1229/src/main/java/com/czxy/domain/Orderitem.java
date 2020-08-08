package com.czxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Table(name = "orderitem")
public class Orderitem {
    @Id
    @Column(name = "itemid")
    @GeneratedValue(generator = "JDBC")
    private Long itemid;

    @Column(name = "`count`")
    private Integer count;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "pid")
    private Long pid;

    @Column(name = "oid")
    private Long oid;

    @Column(name = "pname")
    private String pname;
}