//package com.wx.scheduled.config;
//
//import com.wx.scheduled.service.QuartzService;
//import org.quartz.JobDetail;
//import org.quartz.Trigger;
//import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
//import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//import org.springframework.stereotype.Component;
//
///**
// * User: Mr.Wang
// * Date: 2019/10/28
// */
//@Component
//public class QuartzConfig {
//    /*
//   配置定时任务
//    */
//    @Bean(name = "jobDetailAfterWork")
//    public MethodInvokingJobDetailFactoryBean detailFactoryBean(QuartzService task) { //这里的参数就是我们刚才写的QuartzService的一个实例
//        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
//        /*
//         * 是否并发执行
//         * 例如每5s执行一次任务，但是当前任务还没有执行完，就已经过了5s了，
//         * 如果此处为true，则下一个任务会执行，如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行
//         */
//        jobDetail.setConcurrent(false);
//        //设置定时任务的名字
//        jobDetail.setName("AfterWork");
//        //设置任务的分组，这些属性都可以在数据库中，在多任务的时候使用
//        jobDetail.setGroup("srd");
//
//        //为需要执行的实体类对应的对象
//        jobDetail.setTargetObject(task);
//
//        /*
//         * closeAll为需要执行的方法
//         * 通过这几个配置，告诉JobDetailFactoryBean我们需要执行定时执行QuartzService类中的closeAll方法
//         */
//        jobDetail.setTargetMethod("closeAll");
//        return jobDetail;
//    }
//
//
//    /*
//     配置定时任务的触发器，也就是什么时候触发执行定时任务
//     */
//    @Bean(name = "jobTriggerAfterWork")
//    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetail jobDetailAfterWork) {
//        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
//        trigger.setJobDetail(jobDetailAfterWork);
//        //初始化的cron表达式(20秒一次)
//        trigger.setCronExpression("0/20 * * * * ?");
//        //trigger的name
//        trigger.setName("AfterWorkTrigger");
//        return trigger;
//    }
//
//    /*
//     定义quartz调度工厂
//     */
//    @Bean(name = "scheduler")
//    public SchedulerFactoryBean schedulerFactoryBean(Trigger jobTriggerAfterWork) {
//        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
//        //用于quartz集群，QuartzScheduler启动时更新已存在的job
//        factoryBean.setOverwriteExistingJobs(true);
//        //延时启动，应用启动1秒后
//        factoryBean.setStartupDelay(1);
//        //注册触发器
//        factoryBean.setTriggers(jobTriggerAfterWork);
//        return factoryBean;
//    }
//}
