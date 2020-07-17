package com.wx.concurrent.deadlock;

import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: Mr.Wang
 * Date: 2019/12/8
 */
public class Test1 implements Runnable {

    public int flag1 = 0;
    //静态对象是所有类的共享对象
    private static Object o1 = new Object(), o2 = new Object();

    @Override
    public void run() {
        System.out.println(flag1);
        if (flag1 == 0) {
            synchronized (o1) {
                System.out.println("o1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("o2");
                }
            }
        }
        if (flag1 == 1) {
            synchronized (o2) {
                System.out.println("o22");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("o11");
                }
            }
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test1 test2 = new Test1();
        test1.flag1 = 0;
        test2.flag1 = 1;
        new Thread(test1).start();
        new Thread(test2).start();

    }
}
