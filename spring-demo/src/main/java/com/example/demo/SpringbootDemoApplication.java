package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;//千万不能用org

/**
 * @ImportResource 的作用是给容器中导入一个spring的配置文件(beans.xml),让配置文件的内容生效.(不推荐使用)
 * 推荐使用编写配置类的方式:
 * @configutation 作用:指定当前类是一个配置类,这个配置类就是用来替代之前的spring-xxx.xml的配置文件的
 *
 * 在配置文件中用<bean><bean/>标签添加组件
 */
//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
@MapperScan(basePackages = {"com.example.demo.Dao"})
@EnableScheduling//开启定时任务
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}
