package com.wx.springapplication.context;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * User: Mr.Wang
 * Date: 2019/10/24
 */

/**
 * 进去新增的监听
 */
@Component
public class SenceListener implements ApplicationListener<SenceAddEvent> {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SenceListener.class);

    @Override
    public void onApplicationEvent(SenceAddEvent senceAddEvent) {

        logger.info("新增景区" + senceAddEvent.getName() + "," + new Date(senceAddEvent.getTimestamp()));
    }
}
