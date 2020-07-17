package com.wx.springinaction;

import com.wx.springinaction.service.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@SpringBootApplication
public class SpringInActionApplication {


    public static void main(String[] args) {
     SpringApplication.run(SpringInActionApplication.class, args);

    }

}
