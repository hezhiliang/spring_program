package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceDemo {

    private double id;

    private Double age;

    private String name;

    private String address;

    private Date createTime;

    private java.sql.Date updateTime;

}