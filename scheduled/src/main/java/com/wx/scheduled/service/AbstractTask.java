//package com.wx.scheduled.service;
//
//
//import com.wx.scheduled.domain.TaskIdEnum;
//import com.wx.scheduled.mapper.ScheduleLockMapper;
//import com.wx.scheduled.utils.SpringBeanUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 抽象任务骨架定义
// */
//@Slf4j
//public abstract class AbstractTask implements Runnable{
//
//    private TaskIdEnum taskIdEnum;
//    private String cron;
//
//    private ScheduleLockMapper lockMapper = SpringBeanUtil.getBean(ScheduleLockMapper.class);
//
//    public AbstractTask(TaskIdEnum taskIdEnum,String cron) {
//        this.taskIdEnum = taskIdEnum;
//        this.cron = cron;
//    }
//
//    @Transactional
//    @Override
//    public void run() {
//        String taskId = taskIdEnum.getTaskId();
//        String ip = IPV4Util.getLocalIpv4Address();
//        Map<String,Object> map = new HashMap<>();
//        map.put("taskId",taskId);
//        map.put("execIp",ip);
//        int lock = lockMapper.lock(map);
//        log.info("lock: taskId=[{}],ip=[{}],lock=[{}]", taskId, ip, lock);
//        if (lock == 1) {
//            log.info("taskId:[{}],任务执行开始时间:[{}]", taskId, DateUtil.now());
//            doWork();
//            log.info("taskId:[{}],任务执行结束时间:[{}]", taskId, DateUtil.now());
//
//            int unlock = lockMapper.unlock(map);
//            log.info("unlock: taskId=[{}],ip=[{}],unlock=[{}]", taskId, ip, unlock);
//        }
//    }
//
//    protected abstract void doWork();
//
//    public TaskIdEnum getTaskIdEnum() {
//        return taskIdEnum;
//    }
//
//    public String getCron() {
//        return cron;
//    }
//}
