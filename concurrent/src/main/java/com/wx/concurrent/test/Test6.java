package com.wx.concurrent.test;

import java.util.concurrent.*;

/**
 * User: Mr.Wang
 * Date: 2019/11/24
 */
public class Test6 {

    private final static int COUNT = 100;

    public static void main(String[] args) throws Exception {
        final Semaphore semaphore = new Semaphore(20);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < COUNT; i++) {
            final int a = i;
            executorService.execute(() -> {
                try {
//
                    semaphore.acquire(); //获得许可
                    getStr(a);
                    semaphore.release();//释放许可
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("Finished");
        executorService.shutdown();
    }

    private static void getStr(int i) {
        System.out.println(i);
    }
}
