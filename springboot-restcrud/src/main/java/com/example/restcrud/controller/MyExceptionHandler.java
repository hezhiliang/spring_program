package com.example.restcrud.controller;

import com.example.restcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hzl
 * @Description: 自定义的异常处理器
 * @Date: Create in 2019/8/5 15:57
 * @Modified By:
 */
@ControllerAdvice
public class MyExceptionHandler {

    //1.这种方式：浏览器 和 其他客户端 请求返回的都是json数据，没有做自适应
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleEeception(Exception e){
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("code","user not exist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    //2.做错误页面返回数据自适应显示处理(浏览器访问就返回 ModelAndView ，其他客户端调用就返回json错误数据)
    @ExceptionHandler(UserNotExistException.class)
    public String handleEeception(Exception e, HttpServletRequest request) {
        /**
         * 在 BasicErrorController 类中,获取错误码的源码如下：
         * Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
         */
        /*为了解决错误页面没有显示我们自定义的错误码的问题和错误页面没有跳转到我们自定义的错误视图页面，
            我们需要传入 4xx,5xx 错误码，SpringMvc的DefaultErrorVieWResolver.resolveErrorView()会自动解析
            到错误码对应的 4xx.html或5xx.html页面(精确优先)
        */
        request.setAttribute("javax.servlet.error.status_code", 418);

        Map<String, Object> map = new HashMap<>();
        map.put("code", "user not exist");
        map.put("message", e.getMessage());

        //把自定义的错误参数放入attribute中
        request.setAttribute("ext",map);

        //转发到/error,即可做自适应
        return "forward:/error";
    }
}
