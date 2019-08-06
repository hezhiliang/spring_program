package com.example.restcrud.controller;

import com.example.restcrud.dao.DepartmentDao;
import com.example.restcrud.dao.EmployeeDao;
import com.example.restcrud.entities.Department;
import com.example.restcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

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
        //放在请求域中
        model.addAttribute("emps",employees);

        //默认thymeleaf会从这个路径下拼："classpath:/templates/xxx.html";
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAdd(Model model){
        //查部门名
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //来到添加页面
        return  "emp/add";
    }

    //员工添加
    //SpringMvc自动将请求参数和入参对象的属性进行一一绑定，要求了请求参数的名字和javaBean入参对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("添加的员工数据为：" + employee);
        employeeDao.save(employee);
        //来到员工列表页面
        //redirect:表示重定向到一个地址  /代表当前路径
        //forward： 代表转发到一个地址
        return "redirect:/emps";
    }

    //来到修改员工页面，查出当前员工数据，在页面回显
    @GetMapping("/emp/{id}")
    public String updateEmp(@PathVariable Integer id ,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面(add.list是一个修改添加二合一的页面)；
        return "emp/add";
    }

    //员工修改，需要提交员工id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据为："+ employee);
        employeeDao.save(employee);
        //重定向到列表页面
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable Integer id ,Model model){

        System.out.println("需要删除的员工id为：" + id);
        employeeDao.delete(id);
        //删除后重定向到员工列表页面
        return "redirect:/emps";
    }
}
