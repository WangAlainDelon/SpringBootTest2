package com.wx.concurrent.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: Mr.Wang
 * Date: 2019/11/10
 */
public class Count {
    // 共享变量
    private AtomicInteger integer = new AtomicInteger(0);

    public AtomicInteger getCount() {
        return integer;
    }

    public void increase() {

        integer.getAndIncrement();
    }
}
