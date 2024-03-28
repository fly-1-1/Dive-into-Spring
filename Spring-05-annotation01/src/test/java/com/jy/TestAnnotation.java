package com.jy;

import com.jy.bean.User;
import com.jy.lazy.Account;
import com.jy.scope.Customer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        User user = (User) ctx.getBean("user");
        System.out.println(user);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer1 = (Customer) ctx.getBean("customer");
        Customer customer2 = (Customer) ctx.getBean("customer");
        System.out.println(customer1);
        System.out.println(customer2);
    }

    @Test
    public void test3(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //Account account = (Account) ctx.getBean("account");
        //System.out.println(account);
    }
}
