package com.wx.concurrent.annotation;

import java.lang.annotation.*;

/**
 * User: Mr.Wang
 * Date: 2019/11/9
 * 不推荐的写法
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface NotRecommend {
    String value() default "";
}
