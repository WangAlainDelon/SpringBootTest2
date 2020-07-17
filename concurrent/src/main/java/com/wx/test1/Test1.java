package com.wx.test1;

import java.lang.reflect.Proxy;

/**
 * User: Mr.Wang
 * Date: 2020/1/27
 */
public class Test1 {
    public static void consumer(Interface anInterface) {
        anInterface.doSomething();
        anInterface.somethingElse("boom");
    }

    public static void main(String[] args) {
//        //正常业务调用
//        RealObject realObject = new RealObject();
//        consumer(realObject);
        //现在擦汗如一个代理的调用链
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Interface interfaces = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
//                realObject.getClass().getInterfaces(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(new RealObject())
        );
        consumer(interfaces);
    }

}
