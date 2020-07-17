//package com.wx.scheduled.config;
//
//import com.wx.scheduled.service.QuartzService;
//import org.quartz.CronScheduleBuilder;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * User: Mr.Wang
// * Date: 2019/10/28
// */
//@EnableScheduling
//@Configuration
//@Component
//public class QuartzRefreshConfig {
//    @Autowired
//    private QuartzService quartzService;
//
//    @Resource(name = "jobTriggerAfterWork")
//    private CronTrigger cronTriggerAfterWork;
//
//    @Resource(name = "scheduler")
//    private Scheduler scheduler;
//
//    /*
//    每隔10s查库，并根据查询结果决定是否重新设置定时任务
//    */
//
//    @Scheduled(fixedRate = 10000)
//    public void scheduleUpdateCronTrigger() throws SchedulerException {
//        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTriggerAfterWork.getKey());
//        //当前Trigger使用的
//        String currentCron = trigger.getCronExpression();
//        //从数据库查询出来的
//        String searchCron = quartzService.getTaskById(1); //这里是数据库的查询操作，根据自己的情况自己写
//
//        if (currentCron.equals(searchCron)) {
//            // 如果当前使用的cron表达式和从数据库中查询出来的cron表达式一致，则不刷新任务
//        } else {
//            //表达式调度构建器
//            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
//            //按新的cronExpression表达式重新构建trigger
//            trigger = (CronTrigger) scheduler.getTrigger(cronTriggerAfterWork.getKey());
//            trigger = trigger.getTriggerBuilder().withIdentity(cronTriggerAfterWork.getKey()).withSchedule(scheduleBuilder).build();
//            // 按新的trigger重新设置job执行
//            scheduler.rescheduleJob(cronTriggerAfterWork.getKey(), trigger);
//            currentCron = searchCron;
//        }
//    }
//}
