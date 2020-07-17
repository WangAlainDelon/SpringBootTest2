package com.wx.springinaction.service.imp;

import com.wx.springinaction.service.Performance;
import org.springframework.stereotype.Service;

/**
 * User: Mr.Wang
 * Date: 2020/2/8
 */
@Service
public class PerformanceImpl implements Performance {
    @Override
    public void perform(String msg) {
        System.out.println(msg);
        System.out.println("The actors are performing");
    }
}
