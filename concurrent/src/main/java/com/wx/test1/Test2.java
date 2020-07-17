package com.wx.test1;

import net.sf.cglib.proxy.Enhancer;

/**
 * User: Mr.Wang
 * Date: 2020/1/27
 */
public class Test2 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealObject.class);
        enhancer.setCallback(new DynamicCGLibHandler());
        Interface anInterface = (Interface) enhancer.create();
        anInterface.doSomething();

    }
}
