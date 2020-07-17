package com.wx.springapplication.listener;

import com.wx.springapplication.context.SenceAddBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * User: Mr.Wang
 * Date: 2019/10/24
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldRefeshApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        SenceAddBean bean = applicationContext.getBean(SenceAddBean.class);
        bean.addSence("十二挑");
        System.out.println("上下文加载完成，(BeFore):" + contextRefreshedEvent.getTimestamp());
    }
}
