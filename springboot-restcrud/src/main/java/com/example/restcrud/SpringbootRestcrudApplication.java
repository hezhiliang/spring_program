package com.example.restcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRestcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestcrudApplication.class, args);
	}

//	@Bean //如果自己注入了 ViewResolver 组件，原本的ViewResolver自动配置就会失效
//	public ViewResolver myViewResolver(){
//		return  new MyViewResolver();
//	}
//
//	private  static  class  MyViewResolver implements ViewResolver{
//
//		@Override
//		public View resolveViewName(String viewName, Locale locale) throws Exception {
//			return null;
//		}
//	}
}
