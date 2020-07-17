package com.wx.concurrent.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: Mr.Wang
 * Date: 2019/11/10
 */
public class Test3 {

    public void test1() {
        synchronized (Test3.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    public static synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        Test3 test4 = new Test3();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> test3.test1());
        executorService.execute(() -> test4.test1());

    }
}
