package com.example.restcrud.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: hzl
 * @Description: 自定义过滤器
 * @Date: Create in 2019/8/6 14:56
 * @Modified By:
 */
public class MyFilter implements Filter {
    //初始化的时候执行
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //过滤
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        chain.doFilter(request,response);//放行
    }

    @Override
    public void destroy() {

    }
}
