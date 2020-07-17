package com.wx.test1;

/**
 * User: Mr.Wang
 * Date: 2020/1/27
 */
public class RealObject  implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse" + arg);
    }
}
