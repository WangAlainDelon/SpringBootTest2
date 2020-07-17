package com.wx.springapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * User: Mr.Wang
 * Date: 2019/10/24
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldCloseApplicationListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("上下文关闭加载：" + contextClosedEvent.getTimestamp());
    }
}
