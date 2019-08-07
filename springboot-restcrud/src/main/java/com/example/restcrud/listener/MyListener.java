package com.example.restcrud.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: hzl
 * @Description: 自定义Listener,Listener有很多种,此处实现 ServletContextListener ,作用：监听Servlet启动和销毁
 * @Date: Create in 2019/8/6 15:03
 * @Modified By:
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized...web应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed...当前web应用销毁");
    }
}
