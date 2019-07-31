package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource(value = "classpath:tUser.properties")//这个注解可以加载指定的配置文件
public class HelloController {
    @Value("${tUser.username}")
    private String name;

    @RequestMapping("/sayhello")
    public String sayHello(){
        return "Hello" + name;
    }
}
