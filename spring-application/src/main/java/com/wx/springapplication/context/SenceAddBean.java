package com.wx.springapplication.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * User: Mr.Wang
 * Date: 2019/10/24
 */

/**
 * 定义触发事件的Bean
 */
@Component
public class SenceAddBean implements ApplicationContextAware {

    private ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void addSence(String name) {
        //省略新增景区的核心代码......

        SenceAddEvent senceAddEvent = new SenceAddEvent(
                applicationContext, name);
        applicationContext.publishEvent(senceAddEvent);
    }
}
