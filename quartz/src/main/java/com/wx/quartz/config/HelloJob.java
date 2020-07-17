package com.wx.quartz.config;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * User: Mr.Wang
 * Date: 2019/10/28
 */
//1.实现job接口
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //2.编写具体的业务逻辑
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println(format);
        System.out.println("Hello Word!");
    }
}
