package com.wx.concurrent.test;

import java.lang.reflect.Modifier;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * User: Mr.Wang
 * Date: 2019/11/9
 */
public class Test1 {
    private static AtomicInteger integer = new AtomicInteger(1);
    private static int[] array = {1, 2};
    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);

    private static AtomicReference<User> userAtomicReference = new AtomicReference<>();

    private static AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater
            = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public static void main(String[] args) {


        //原子更新基本类型 AtomicBoolean，AtomicInteger，AtomicLong
        System.out.println(integer.get());
        System.out.println(integer.getAndIncrement());
        System.out.println(integer.addAndGet(5));


        //原子更新数组 AtomicIntegerArray，AtomicLongArray，AtomicReferenceArray
        System.out.println(atomicIntegerArray.addAndGet(0, 4));
        System.out.println(atomicIntegerArray.getAndSet(0, 3));
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(array[0]);

        //原子跟新多个变量的时候就使用原子更新引用类型提供的类
        //AtomicReference  AtomicReferenceFieldUpdater  AtomicMarkableReference

        User user = new User("Mr.Wang", 25);
        userAtomicReference.set(user);
        User newUser = new User("Mr.Zhang", 26);
        userAtomicReference.compareAndSet(user, newUser);
        System.out.println(userAtomicReference.get().getName());
        System.out.println(userAtomicReference.get().getOld());


        //原子跟新字段类
        User user1 = new User("Mr.Wang", 25);
        atomicIntegerFieldUpdater.getAndIncrement(user1);
        System.out.println(atomicIntegerFieldUpdater.get(user1));

    }
}
