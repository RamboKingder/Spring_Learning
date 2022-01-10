package com.lxl.aopAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect // 告知Spring容器当前MyAspect类是一个切面类
public class MyAspect {

    @Pointcut("execution(* com.lxl.aopAnnotation.Target.*(..))")
    public void myPoint(){}

    @Before("MyAspect.myPoint()")
    public void beforeEnhance(){
        System.out.println("前置增强，在切点的前面执行.......");
    }
    @AfterReturning("myPoint()")
    public void afterReturningEnhance(){
        System.out.println("后置增强，在切点执行后执行.......");
    }
    @Around("myPoint()")
    public Object aroundEnhance(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强，在切点之前会执行......");
        // Proceeding JoinPoint：切点
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强，在切点之后会执行......");
        return proceed;
    }
    @After("myPoint()")
    public void afterEnhance(){
        System.out.println("最终增强，无论切点是否执行，最终增强都会执行......");
    }
    @AfterThrowing("myPoint()")
    public void throwingEnhance(){
        System.out.println("异常抛出增强，只有在切点抛出异常的时候才会执行......");
    }
}
