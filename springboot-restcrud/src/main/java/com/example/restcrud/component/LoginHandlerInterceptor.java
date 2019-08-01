package com.example.restcrud.component;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置拦截器：
 *  作用是：做登录的检查
 */
//注入到spring容器中，因为拦截器属于SpringMvc的内部功能，所以统一写在了MyMvcConfig配置类中
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null){
            //未登录,返回登录页面
            request.setAttribute("msg","没有权限,请先登录!");
            //request.getRequestDispatcher()  获取转发器地址
            //.forward(request,response)  转发
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            //已登录,放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
