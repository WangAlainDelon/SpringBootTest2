//package com.wx.springapplication;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//public class Application {
//
//    public static void main(String[] args) {
////        SpringApplication.run(ApplicationConfig.class, args);
//
//        Set<String> sources = new HashSet<>();
//        sources.add(ApplicationConfig.class.getName());
//        SpringApplication springApplication = new SpringApplication();
//
//        springApplication.setSources(sources);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
//        springApplication.run(args);
////        ApplicationConfig bean = applicationContext.getBean(ApplicationConfig.class);
////        System.out.println(bean);
////        SenceAddBean addBean = applicationContext.getBean(SenceAddBean.class);
////        addBean.addSence("斑竹林");
//
//    }
//
//    @SpringBootApplication
//    public static class ApplicationConfig {
//
//    }
//}
