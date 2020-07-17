package com.wx.concurrent.test;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: Mr.Wang
 * Date: 2019/11/12
 */
public class Test5 {

    private int a = 1;

    public Test5() {
        new InnerClass();
    }

    class InnerClass {
        public InnerClass() {
            System.out.println(Test5.this.a);
        }
    }

    public static void main(String[] args) {
        new Test5();
       // Collections.unmodifiableMap();



    }
}
