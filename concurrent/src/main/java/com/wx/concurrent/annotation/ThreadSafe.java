package com.wx.concurrent.annotation;

import java.lang.annotation.*;

/**
 * User: Mr.Wang
 * Date: 2019/11/9
 * 用来标记线程安全的类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface ThreadSafe {
    String value() default "";
}
