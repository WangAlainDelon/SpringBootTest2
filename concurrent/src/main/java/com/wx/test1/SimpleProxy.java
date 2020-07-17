package com.wx.test1;

/**
 * User: Mr.Wang
 * Date: 2020/1/27
 */
public class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        proxied.doSomething();
        System.out.println("SimpleProxy doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        proxied.somethingElse(arg);
        System.out.println("SimpleProxy " + arg);
    }
}
