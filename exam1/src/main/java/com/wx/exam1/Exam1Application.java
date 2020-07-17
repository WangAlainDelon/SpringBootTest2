package com.wx.exam1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
/**通用Mapper的包扫描配置*/
@MapperScan("com.wx.exam1.dao")
//MyBatis中使用Servlet的配置
@ServletComponentScan
public class Exam1Application {
    public static void main(String[] args) {
        SpringApplication.run(Exam1Application.class, args);
    }

}
