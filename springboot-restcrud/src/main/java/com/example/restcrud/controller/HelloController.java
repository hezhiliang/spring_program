package com.example.restcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //写一个空方法映射到/templates/login.html (不推荐这样写,虽然也能实现,最好写一个配置类)
//    @RequestMapping({"/","/login.html"})
//    public String index(){
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "HelloWorle!";
    }
}
