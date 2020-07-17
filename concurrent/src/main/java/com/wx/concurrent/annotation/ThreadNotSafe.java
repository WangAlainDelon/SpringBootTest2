package com.wx.concurrent.annotation;

import java.lang.annotation.*;

/**
 * User: Mr.Wang
 * Date: 2019/11/9
 * 用来标记线程不安全的类
 */
@Retention(RetentionPolicy.SOURCE)
@Documented
@Target(ElementType.TYPE)
public @interface ThreadNotSafe {
    String value() default "";
}
