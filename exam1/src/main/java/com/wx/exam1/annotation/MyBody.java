package com.wx.exam1.annotation;

import java.lang.annotation.*;

/***
 * 自定义RequestBody注解自 定义请求参数解析注解1
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyBody {
    String value();
}