package com.example.restcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
//    @GetMapping
//    @PutMapping
//    @DeleteMapping
    //    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登录成功,防止表单重复提交，可以使用重定向到主页
//            return "dashboard";
            session.setAttribute("loginUser",username);//将已经登录的用户信息放入seesion中
            return "redirect:/main.html";
        } else {
            //登录失败
            map.put("msg","用户名或密码错误!");
            return "login";
        }

    }



}
