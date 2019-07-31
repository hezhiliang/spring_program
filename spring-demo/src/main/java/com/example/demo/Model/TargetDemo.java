package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TargetDemo {

    private Double id;
    private double age;
    private String name;

    private String email;

    private String createTime;

    private String updateTime;

}