package com.jy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 1.额外功能
 * 2.切入点
 */

@Aspect
public class MyAspect {

    @Pointcut("execution(* *..UserServiceImpl.*(..))")
    public void myPointCut(){};

    //@Around("execution(* login(..))")
    @Around(value = "myPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("---aspect log---");
        Object ret = joinPoint.proceed();
        return ret;
    }

    //@Around("execution(* login(..))")
    @Around(value = "myPointCut()")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("---aspect tx---");
        Object ret = joinPoint.proceed();
        return ret;
    }

}
