package com.jy.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Around implements MethodInterceptor {
    /*
     * invoke作用:额外功能书写在invoke中
     * 可以运行在原始方法 之前 之后 之前&之后
     * 确定:原始方法如何运行
     * MethodInvocation:额外功能所增加的原始方法
     * methodInvocation.proceed();运行原始方法
     * 返回值:原始方法执行后的返回值(原始方法的返回值)
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
       /* System.out.println("--额外功能之前--");
        Object ret = methodInvocation.proceed();
        System.out.println("--额外功能之后--");*/

        Object ret = null;
        try {
            ret = methodInvocation.proceed();
        } catch (Throwable e) {
            System.out.println("原始方法抛出异常 执行额外功能!");
            e.printStackTrace();
        }

        return ret;
    }
}
