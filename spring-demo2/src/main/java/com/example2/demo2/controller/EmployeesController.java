package com.example2.demo2.controller;


import com.example2.demo2.bean.Employees;
import com.example2.demo2.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/emp")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;


    @GetMapping("/getEmps")
    public ResponseEntity<List> getEmp(){
        List<Employees> empList = new ArrayList<>(1);
        try {
            empList = employeesService.getEmps();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return  ResponseEntity.status(HttpStatus.OK).body(empList);
    }



}
