package com.wx.springtxjpa.controller;

import com.wx.springtxjpa.service.UserServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.transaction.TransactionManager;

/**
 * User: Mr.Wang
 * Date: 2020/1/4
 */
@RestController
@RequestMapping("/v1/jms")
public class UserController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/test/param")
    public void test(@RequestBody String name,
                     @RequestBody String age){
        // Body：  name=MrWang
        // Param ：Mr.Wang
        System.out.println(name);
    }


    /**
     * 往消息队列插消息的接口
     *
     * @param msg
     */
    @PostMapping("/message1/listen")
    public void createMsgWithListener(@RequestParam String msg) {
        jmsTemplate.convertAndSend("customer:msg:new", msg);
    }

    @PostMapping("/message1/direct")
    public void createMsgDirect(@RequestParam String msg) {
        userService.handle(msg);
    }

    /**
     * 从消息队列取消息的接口
     * @return
     */
    @GetMapping("/message")
    public String getMsg() {
        jmsTemplate.setReceiveTimeout(2000);
        Object reply = jmsTemplate.receiveAndConvert("customer:msg:reply");
        return String.valueOf(reply);
    }
}
