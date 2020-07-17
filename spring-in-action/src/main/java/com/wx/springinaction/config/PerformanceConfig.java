package com.wx.springinaction.config;

import com.wx.springinaction.aspect.Audience;
import com.wx.springinaction.aspect.EncoreableIntrodeucer;
import com.wx.springinaction.service.Encoreable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * User: Mr.Wang
 * Date: 2020/2/8
 */
@Configuration
@EnableAspectJAutoProxy //启动AspectJ自动代理
@ComponentScan("com.wx.springinaction.service")
public class PerformanceConfig {
    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public EncoreableIntrodeucer encoreableIntrodeucer() {
        return new EncoreableIntrodeucer();
    }
}
