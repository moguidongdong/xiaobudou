package com.ex.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {

    @Pointcut("execution(int com.ex.service.MathCalculator.div(int,int))")
    public void pointCut() {
    }

    @Before("com.ex.service.LogAspects.pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " 除法运行,参数是：" + Arrays.asList(joinPoint.getArgs()));
    }

    @After("com.ex.service.LogAspects.pointCut()")
    public void logEnd() {
        System.out.println("除法结束");
    }

    @AfterReturning(value = "com.ex.service.LogAspects.pointCut()", returning = "result")
    public void logReturn2(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "除法返回" + result);
    }

    @AfterThrowing(value = "com.ex.service.LogAspects.pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("除法异常");
    }

}
