package com.example.demo.TimesTask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledTasks {

//    @Scheduled(cron = "0 */1 * * * ?")//cron表达式,每隔一分钟执行1次
//    @Scheduled(cron = "*/5 * * * * ?")//cron表达式, 每隔5秒执行一次
//    public void pushDataScheduled(){
//        System.out.println("我正在执行.." + new Date());
//    }

//    @Scheduled(cron = "0/10 * * * * *")
//    @Scheduled(fixedRate = 1000 * 1)// 固定间隔时间,每一秒执行一次
//    public void add() {
//        log.info("我正在执行.."+System.currentTimeMillis());
//    }
}
