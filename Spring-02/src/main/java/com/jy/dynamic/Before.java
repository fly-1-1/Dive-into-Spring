package com.jy.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before implements MethodBeforeAdvice {
    //需要将运行在原始方法之前的功能,写在before中
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("---method before advice log---");
    }
}
