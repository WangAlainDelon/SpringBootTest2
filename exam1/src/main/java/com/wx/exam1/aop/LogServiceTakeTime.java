package com.wx.exam1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AOP拿到Service层执行的时间
 */
/*@Aspect
@Component*/
public class LogServiceTakeTime {
    private final static Logger log = LoggerFactory.getLogger(LogServiceTakeTime.class);

    @Pointcut("execution(public * com.wx.exam1.dao.*.*(..))")
    public void performance() {
    }

    @Around("performance()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {

        //记录起始时间
        long begin = System.currentTimeMillis();
        Object result = "";
        /** 执行目标方法 */
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            log.error("日志记录发生错误, errorMessage: {}", e.getMessage());
        } finally {
            /** 记录操作时间 */
            long took = System.currentTimeMillis() - begin;
            if (took >= 10000) {
                log.error("dao 执行时间为: {}m秒", took);
                //                log.error("Controller 执行时间为: {}毫秒", took);
            } else if (took >= 5000) {
                log.warn("dao 执行时间为: {}m秒", took);
                //                log.warn("Controlle r执行时间为: {}毫秒", took);
            } else if (took >= 3000) {
                log.info("dao执行时间为: {}m秒", took);
                //                log.info("Controller 执行时间为: {}毫秒", took);
            }
            // TODO 日志保存到MongoDB中
        }
        return result;
    }

    @Before("performance()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        log.info("doBefore");
    }

    @AfterReturning(returning = "ret", pointcut = "performance()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("doAfterReturning");
    }

}
