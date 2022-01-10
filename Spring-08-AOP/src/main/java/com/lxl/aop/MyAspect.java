package com.lxl.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void beforeEnhance(){
        System.out.println("前置增强，在切点的前面执行.......");
    }
    public void afterReturningEnhance(){
        System.out.println("后置增强，在切点执行后执行.......");
    }
    public Object aroundEnhance(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强，在切点之前会执行......");
        // Proceeding JoinPoint：切点
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强，在切点之后会执行......");
        return proceed;
    }
    public void afterEnhance(){
        System.out.println("最终增强，无论切点是否执行，最终增强都会执行......");
    }
    public void throwingEnhance(){
        System.out.println("异常抛出增强，只有在切点抛出异常的时候才会执行......");
    }
}
