package com.wx.springinaction.web;

import com.wx.springinaction.service.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: Mr.Wang
 * Date: 2020/2/8
 */
@RestController
public class IndexController {
    @Autowired
    private Performance performance;

    @GetMapping("/test")
    public void test() {
//        performance.perform(p);
    }
}
