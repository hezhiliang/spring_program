package com.example.restcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    //写一个空方法映射到/templates/login.html (不推荐这样写,虽然也能实现,最好写一个配置类)
//    @RequestMapping({"/","/login.html"})
//    public String index(){
//        return "index";
//    }

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "HelloWorle!";
    }

    //查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success1(Map<String,Object> map){
        //classpath:/templates/success.html
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";//themeleaf 模板引擎会自动前后拼串，跳转到 资源路径下的 '/templates/success.html'
    }
}
