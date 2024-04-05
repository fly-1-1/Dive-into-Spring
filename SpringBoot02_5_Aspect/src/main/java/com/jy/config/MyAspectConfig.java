package com.jy.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;

//@Configuration
//@Aspect
public class MyAspectConfig {


    @Around("execution(* com.jy.service.*.*(..))")
    public Object Around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("========log=======");

        Signature signature = point.getSignature();
        Object[] args = point.getArgs();
        args[0] = "Lisi";
        point.proceed(args);
        return point.proceed();
    }

    //@Before("execution(* com.jy.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("========before=======");
        System.out.println("当前目标类:" + joinPoint.getTarget());
        System.out.println("当前目标方法名:" + joinPoint.getSignature().getName());

    }

    //@After("execution(* com.jy.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("========after=======");
        System.out.println("当前目标类:" + joinPoint.getTarget());
        System.out.println("当前目标方法:" + joinPoint.getSignature().getName());
    }

}
