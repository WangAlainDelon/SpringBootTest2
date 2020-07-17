package com.wx.springinaction.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * User: Mr.Wang
 * Date: 2020/2/8
 */
@Aspect
public class Audience {

    //定义命名的切点
    @Pointcut("execution(* *com.wx.springinaction.service.Performance.perform(String))&&args(message)")
    public void performance(String message) {
    }

//    @Before("performance()")
//    public void silenceCellPhone() {
//        System.out.println("看表演之前，观众将收集调成静音");
//    }
//
//    @Before("performance()")
//    public void takeSeats() {
//        System.out.println("观众入席坐好");
//    }
//
//    // @After  和 @AfterReturning区别：@After=@AfterReturning+@AfterThrowing
//    @AfterReturning("performance()")
//    public void applause() {
//        System.out.println("演出结束观众鼓掌");
//    }
//
//    @AfterThrowing("performance()")
//    public void demandRefund() {
//        System.out.println("演出失败，观众要求退款！！！");
//    }

    @Around("performance(message)")
    public void around(ProceedingJoinPoint proceedingJoinPoint,String message) {
        try {
            System.out.println("看表演之前，观众将收集调成静音");
            System.out.println("观众入席坐好");
            System.out.println(message);
            proceedingJoinPoint.proceed();
            System.out.println("演出结束观众鼓掌 !!");
        } catch (Throwable e) {
            System.out.println("演出失败，观众要求退款！！！");
        }
    }
}
