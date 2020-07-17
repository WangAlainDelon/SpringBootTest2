package com.wx.springapplication.autoconfigure;


import java.lang.annotation.*;

/**
 * User: Mr.Wang
 * Date: 2020/2/25
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateLog {
    //操作的类型
    String type() default "";

    //记录操作的内容
    String content() default "";

}
