package com.example.restcrud.controller;

import com.example.restcrud.dao.DepartmentDao;
import com.example.restcrud.dao.EmployeeDao;
import com.example.restcrud.entities.Department;
import com.example.restcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class CustomerController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);

        //默认thymeleaf会从这个路径下拼："classpath:/templates/";
        return "emps/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAdd(Model model){
        //查部门名
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //来到添加页面
        return  "emps/add";
    }
}
