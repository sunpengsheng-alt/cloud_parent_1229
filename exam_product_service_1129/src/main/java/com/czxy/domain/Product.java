package com.czxy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "pid")
    private Long pid;

    @Column(name = "pname")
    private String pname;

    @Column(name = "market_price")
    private Double marketPrice;

    @Column(name = "pimage")
    private String pimage;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    @Column(name = "pdate")
    private Date pdate;

    @Column(name = "pdesc")
    private String pdesc;

    @Column(name = "cid")
    private Long cid;

    private Category category;

    @JsonFormat(pattern = "YYYY-MM-dd")
    public Date getPdate() {
        return pdate;
    }
}