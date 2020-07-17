package com.wx.test1;



import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * User: Mr.Wang
 * Date: 2020/1/27
 */
public class DynamicCGLibHandler implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object re = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return re;
    }
}
