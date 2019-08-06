package com.example.restcrud.config;

import com.example.restcrud.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableWebMvc //全面接管SpringMvc  会导致：SpringBoot对SpringMVC的自动配置都失效,只有SprinMvc的基本配置。所有不使用该注解
//使用WebMvcConfigurerAdapter可以来扩展SpringMvc的功能
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override //重写视图解析器，拓展视图解析器功能
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
    //所有的 WebMvcConfigurerAdapter 组件都会一起起作用
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            //注册视图解析器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");//首页
            }

            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        .addPathPatterns("/**")//拦截任意多层路径下的任意请求
//                        .excludePathPatterns("/", "/login.html", "/index.html", "/user/login");//排除访问登录页面的请求

                //另外,以前在eclipse中是需要配置静态资源的拦截器的,现在springboot已经帮我们做好了,所以不用写.
//            }

        };
        return adapter;
    }

    /**
     * 注入自定义的区域信息解析器组件
     * 需要把resolveLocale注入容器中,替换默认的resolveLocale
     */
    @Bean //将方法名'localeResolver'作为容器的id注入容器,替换默认的localeResolver
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

}
