package com.example2.demo2.service.Impl;

import com.example2.demo2.bean.Employees;
import com.example2.demo2.dao.EmployeesMapper;
import com.example2.demo2.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesMapper employeesMapper;

    @Override
    public List<Employees> getEmps() {
        List<Employees> employees = employeesMapper.selectAll();
        return employees;
    }
}
