//package com.wx.scheduled.service.impl;
//
//import com.wx.scheduled.mapper.ScheduleLockMapper;
//import com.wx.scheduled.service.QuartzService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.stereotype.Service;
//
///**
// * User: Mr.Wang
// * Date: 2019/10/28
// */
//@Service
//@EnableScheduling
//public class QuartzServiceImpl implements QuartzService {
//    @Autowired
//    private ScheduleLockMapper scheduleLockMapper;
//    @Override
//    public void closeAll() {
//        scheduleLockMapper.TurnOffAll();
//        System.out.println("close all");
//    }
//
//}
