package com.jy;

import com.jy.bean.User;
import com.jy.dao.Category;
import com.jy.dao.UserService;
import com.jy.lazy.Account;
import com.jy.life.Product;
import com.jy.scope.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
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

    @Test
    public void test4(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Product product = (Product) ctx.getBean("product");
        ctx.close();
    }

    @Test
    public void test5(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");
        userServiceImpl.register();
    }

    /**
     *  用于测试:Value
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Category category = (Category) ctx.getBean("category");
        System.out.println("category.getId() = " + category.getId());
        System.out.println("category.getName() = " + category.getName());

    }
}
