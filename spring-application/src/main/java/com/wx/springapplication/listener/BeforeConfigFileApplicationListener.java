package com.wx.springapplication.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * User: Mr.Wang
 * Date: 2019/10/25
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener {

    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent environmentPreparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            ConfigurableEnvironment environment = environmentPreparedEvent.getEnvironment();
            String name = environment.getProperty("name");
            System.out.println("yml中的name的值为：" + name);
        }

        if (event instanceof ApplicationPreparedEvent) {
        }

    }

    @Override
    public int getOrder() {
        return -2147483638 + 1;
    }


}
