package com.wx.concurrent.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: Mr.Wang
 * Date: 2019/11/9
 */
@RestController
@Slf4j
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "String";
    }

}
