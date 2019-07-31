//package com.example.demo.TimesTask;
//
//import com.example.demo.Service.ConfigService;
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
//
//@Slf4j
//@Component // 此注解必加
//public class ScheduleRefreshDatabase {
//    @Autowired
//    private ConfigService configService;
//
//    @Resource(name = "jobDetail")
//    private JobDetail jobDetail;
//
//    @Resource(name = "jobTrigger")
//    private CronTrigger cronTrigger;
//
//    @Resource(name = "scheduler")
//    private Scheduler scheduler;
//
//    @Scheduled(fixedRate = 1000 * 30) // 每隔10s查库，并根据查询结果决定是否重新设置定时任务
//    public void scheduleUpdateCronTrigger() throws SchedulerException {
//        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
//
//        String currentCron = trigger.getCronExpression();// 当前Trigger使用的
//        String searchCron = configService.getCronExpression().get(0);// 从数据库查询出来的
//        log.info("当前cron表达式是:" + currentCron);
//        log.info("数据库中的cron表达式是:" + searchCron);
//        if (currentCron.equals(searchCron)) {
//            // 如果当前使用的cron表达式和从数据库中查询出来的cron表达式一致，则不刷新任务
//        } else {
//            // 表达式调度构建器
//            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
//            // 按新的cronExpression表达式重新构建trigger
//            trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
//            trigger = trigger.getTriggerBuilder().withIdentity(cronTrigger.getKey())
//                    .withSchedule(scheduleBuilder).build();
//            // 按新的trigger重新设置job执行
//            scheduler.rescheduleJob(cronTrigger.getKey(), trigger);
//            log.warn("定时任务触发条件更新为:" + configService.getTips().get(0));
//            currentCron = searchCron;
//        }
//    }
//}
