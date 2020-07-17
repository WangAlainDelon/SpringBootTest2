package com.wx.concurrent.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * User: Mr.Wang
 * Date: 2019/12/7
 */
public class Test8 {

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("doSomething in callable");
            Thread.sleep(5000);
            return "callable";
        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new MyCallable());
        System.out.println("doSomeThing in main");
        System.out.println(submit.get());

    }
}
