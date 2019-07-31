package com.example.demo.Config;

import com.example.demo.Service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 推荐使用编写配置类的方式:
 *
 * @configutation 作用:指定当前类是一个配置类,这个配置类就是用来替代之前的spring-xxx.xml的配置文件的
 * <p>
 * 在配置文件中用<bean><bean/>标签添加组件
 */
@Configuration
public class MyAppConfig {

    @Bean //将方法的返回值添加到容器中,容器中这个组件默认的id就是这个方法名.
    public HelloService helloService() {
        System.out.println("加载配置类!");
        return new HelloService();
    }
}
