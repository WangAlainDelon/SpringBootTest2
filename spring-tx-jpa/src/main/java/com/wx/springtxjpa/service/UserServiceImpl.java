package com.wx.springtxjpa.service;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Mr.Wang
 * Date: 2020/1/4
 */
@Service
public class UserServiceImpl {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private JmsTemplate jmsTemplate;


    @Transactional
    @JmsListener(destination = "customer:msg:new")
    public void handle(String msg) {
        logger.info("Get JMS message to from customer:{}", msg);
        String reply = "Replied - " + msg;
        jmsTemplate.convertAndSend("customer:msg:reply", reply);
        if (msg.contains("error")) {
            simulateError();
        }
    }

    private void simulateError() {
        throw new RuntimeException("error");
    }
}
