package com.example.restcrud.config;

import com.example.restcrud.filter.MyFilter;
import com.example.restcrud.listener.MyListener;
import com.example.restcrud.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author: hzl
 * @Description: 自定义 Server 配置
 * @Date: Create in 2019/8/6 11:56
 * @Modified By:
 */
@Configuration
public class MyServerConfig {


    //注册 Servlet 三大组件(Servlet、Filter、Listener)
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));//配置需要拦截的路径
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean<MyListener>(new MyListener());
        return registrationBean;
    }

    /**
     * @Author: hzl
     * @Description: 嵌入式的Servlet容器的定制器；来修改Servlet容器的配置
     * @Date: Create in 2019-08-05
     * @Modified By:
     */
    @Bean //把 EmbeddedServletContainerCustomizer 组件注入Spring容器
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
//                container.setPort(8080);
//                container.setContextPath("/crud");
            }
        };
    }
}
