package com.wx.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User: Mr.Wang
 * Date: 2020/1/27
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("prox:" + proxy.getClass() + ",method:" + method + ",args:" + args);
//        if (args != null) {
//            for (Object arg : args) {
//                System.out.println(" " + arg);
//            }
//        }
        Object re = null;
        try {
            re = method.invoke(proxied, args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("finally");
        }
        return re;
    }
}
