package com.czxy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
public class Product {
    private Long pid;

    private String pname;

    private Double marketPrice;

    private String pimage;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date pdate;

    private String pdesc;

    private Long cid;

    @JsonFormat(pattern = "YYYY-MM-dd")
    public Date getPdate() {
        return pdate;
    }
}