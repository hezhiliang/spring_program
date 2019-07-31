package com.example.demo.TimesTask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component // 此注解必加
public class QuartzScheduledTasks {

    public void test() {
        log.info("我正在执行.."+System.currentTimeMillis());
    }
}
