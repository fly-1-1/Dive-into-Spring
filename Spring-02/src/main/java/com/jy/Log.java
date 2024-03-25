package com.jy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)//决定注解用在哪儿
@Retention(RetentionPolicy.RUNTIME)//决定注解在哪起作用
public @interface Log {
}
