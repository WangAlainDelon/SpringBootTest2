package com.wx.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * User: Mr.Wang
 * Date: 2019/10/26
 */
@SpringBootApplication
public class SpringApplicationBootStrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationBootStrap.class).
                web(WebApplicationType.SERVLET)
                .run(args);
//
//        String name = context.getClass().getName();
//        System.out.println("应用上下文的类型 ConfigurableApplicationContext：" + name);
//        ConfigurableEnvironment environment = context.getEnvironment();
//        System.out.println(" ConfigurableEnvironment" + environment.getClass().getName());
//
//        //关闭上下文
//        context.close();

        SpringApplication.run(SpringApplicationBootStrap.class, args);
    }
}
