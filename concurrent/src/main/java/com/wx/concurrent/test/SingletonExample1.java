package com.wx.concurrent.test;

/**
 * User: Mr.Wang
 * Date: 2019/11/12
 */
public class SingletonExample1 {
    private SingletonExample1() {
    }
    public static SingletonExample1 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
    private enum Singleton {
        INSTANCE;
        private SingletonExample1 instance;
        //用JVM来保证方法绝对只被调用一次
        Singleton() {
            instance = new SingletonExample1();
        }

        public SingletonExample1 getInstance() {
            return instance;
        }
    }
}
