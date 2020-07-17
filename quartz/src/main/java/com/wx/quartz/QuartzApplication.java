package com.wx.quartz;

import com.wx.quartz.config.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@SpringBootApplication
public class QuartzApplication {

    public static void main(String[] args) throws SchedulerException {
        //2.创建一个JobDetail,JobDeatil需要和绑定使用的是Builder模式与发送Saga一样。
        JobDetail jobDetail = JobBuilder
                .newJob(HelloJob.class)
                .withIdentity("myDeatils", "group1")
                .build();
//        JobDetail build = JobBuilder.newJob(HelloJob.class).withIdentity("myDeatils2", "group2").build();
        //3.创建一个Trigger,触发器就可以定义时间的触发策略，这里定义立即执行，并且，每隔两秒执行一次，并且到永远
        SimpleTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();
        //4.创建Schedule，他是通过Factory的模式来创建的。将触发器和Job实例绑定起来
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();
        //打印当前的时间
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println(format);
        scheduler.scheduleJob(jobDetail, trigger);
    }

}
