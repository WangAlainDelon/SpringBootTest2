package com.wx.springinaction.service.imp;

import com.wx.springinaction.service.Encoreable;
import org.springframework.stereotype.Service;

/**
 * User: Mr.Wang
 * Date: 2020/2/8
 */
@Service
public class EncoreableImpl implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println("我是通过AOP引入的新方法");
    }
}
