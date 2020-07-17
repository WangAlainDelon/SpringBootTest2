package com.wx.concurrent.test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: Mr.Wang
 * Date: 2019/11/25
 */
public class Test7 {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            final int a = i;
            executorService.execute(() -> {
                try {
                    getStr(a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void getStr(int i) throws Exception {
        System.out.println(Thread.currentThread().getName() + ":" + i);
        cyclicBarrier.await();
        System.out.println(Thread.currentThread().getName() + ":" + i);
    }

}
