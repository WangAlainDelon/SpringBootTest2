package com.wx.concurrent.test;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: Mr.Wang
 * Date: 2019/12/7
 */
public class Test9 {
    public static void main(String[] args) throws Exception {
        FutureTask<String> stringFutureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("doSomething in callable");
                Thread.sleep(5000);
                return "callable";
            }
        });

        new Thread(stringFutureTask).start();
        System.out.println("doSomeThing in main");
        Thread.sleep(1000);
        String s = stringFutureTask.get();
        System.out.println(s);


    }

}
