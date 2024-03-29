package com.jy;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotation {

    @Test
   public void test01(){
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.jy");
    }
}
