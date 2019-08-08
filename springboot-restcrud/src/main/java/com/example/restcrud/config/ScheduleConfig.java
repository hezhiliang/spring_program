package com.example.restcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author: hzl
 * @Description: 定时任务拓展配置类
 * @Date: Create in 2019/8/8 14:32
 * @Modified By:
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    //重写，添加连接池
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(this.taskExecutor());
    }

    @Bean
    public ScheduledExecutorService taskExecutor() {
        /**
         * Springboot 默认使用单线程
         * this.localExecutor = Executors.newSingleThreadScheduledExecutor();
         */
        return Executors.newScheduledThreadPool(10);//设置线程池为10
    }
}
