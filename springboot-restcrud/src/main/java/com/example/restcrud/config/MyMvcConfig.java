package com.example.restcrud.config;

import com.example.restcrud.component.LoginHandlerInterceptor;
import com.example.restcrud.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//使用WebMvcConfigurerAdapter可以来扩展SpringMvc的功能
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        //浏览器发送/testurl请求来到success
        registry.addViewController("/testurl").setViewName("success");
    }

    /**
     * 配置访问首页的视图解析器(推荐使用该方法,而不使用空方法实现)
     * 注意:所有的WebMvcConfigurerAdapter组件都会一起生效(默认生效的是跳去静态资源路径下的index.html,因此需要加上@Bean注入容器中让这个生效)
     *
     * @return
     */
    @Bean //将这个组件注册到容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");//首页
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {

                //        以前在eclipse中是需要配置静态资源的拦截器的,现在springboot已经帮我们做好了,所以不用写.
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/", "/login.html", "/index.html", "/user/login");
//                super.addInterceptors(registry);
            }

        };
        return adapter;
    }

    /**
     * 注入自定义的区域信息解析器组件
     * 需要把resolveLocale注入容器中,替换默认的resolveLocale
     */
    @Bean //将方法名作为容器的id注入容器
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

}