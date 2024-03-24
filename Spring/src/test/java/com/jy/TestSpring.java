package com.jy;

import com.jy.basic.*;

import com.jy.basic.constructor.Customer;
import com.jy.factorybean.ConnectionFactoryBean;
import com.jy.life.Product;
import com.jy.scope.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestSpring {


    /**
     * 测试工厂类用于解耦合操作
     */
    @Test
    public void test1() {
        //UserService userService = new UserServiceImpl();
        UserService userService = (UserService) BeanFactory.getBean("userService");

        userService.login("name", "suns");

        User user = new User("suns", "123456");

        userService.register(user);
    }

    @Test
    public void test2() {
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println(person);
    }

    /**
     * 测试Spring第一个程序
     */
    @Test
    public void test3() {
        //获得Spring工厂
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //通过工厂类 获得 对象
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

    /**
     * 测试 Spring工厂提供的其他方法
     */
    @Test
    public void test4() {
        //获得Spring工厂
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //通过工厂类 获得 对象
        //Person person = ctx.getBean("person", Person.class);
        //Person person = ctx.getBean(Person.class);
        //String[] beanDefinitionNames = ctx.getBeanDefinitionNames();

        //根据类型获得Spring配置文件中的对应的id值
        /*String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        for (String id : beanNamesForType) {
            System.out.println(id);
        }*/

        //判断是否有id为person的bean 只可以判断id不能判断name
        /*boolean b = ctx.containsBeanDefinition("person");
        System.out.println(b);*/

        //判断是否有id为person的bean 可以判读id name
        /*boolean b = ctx.containsBean("person");
        System.out.println(b);*/
    }

    /**
     * 测试Spring配置文件
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        /*Person person = ctx.getBean(Person.class);
        System.out.println(person);*/

        //这个bean使用一次可以省略id
        //多次使用或者被引用需要设置id
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        for (String id : beanDefinitionNames) {
//            System.out.println(id);
//        }
    }

    /**
     * 测试name属性
     * 相同点 getBean
     * 区别 别名可以定义多个
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("p1");
        System.out.println(person);
    }

    /**
     * 测试注入1
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        person.setId(1);
        person.setName("s");
        System.out.println(person);
    }

    /**
     * 测试注入2
     */
    @Test
    public void test8() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

    /**
     * 测试JDK成员变量赋值
     */
    @Test
    public void test9() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        String[] email = person.getEmails();
        for (String string : email) {
            System.out.println(string);
        }
    }

    /**
     * 测试set
     */
    @Test
    public void test10() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        String[] emails = person.getEmails();
        for (String email : emails) {
            System.out.println("email = " + email);
        }
        System.out.println("--------------------------------------------------");
        Set<String> tels = person.getTels();
        for (String tel : tels) {
            System.out.println("tel = " + tel);
        }
        System.out.println("-----------------------------------------------------");
        List<String> addresses = person.getAddresses();
        for (String address : addresses) {
            System.out.println("address = " + address);
        }
        System.out.println("--------------------------------------------------");

        Map<String, String> qqs = person.getQqs();
        Set<String> keys = qqs.keySet();
        for (String key : keys) {
            System.out.println("key = " + key + " value is " + qqs.get(key));
        }
        System.out.println("-----------------------------------------------");
        Properties p = person.getP();
        System.out.println("key is key1"+ " values is "+p.getProperty("key1"));
        System.out.println("key is key2"+ " values is "+p.getProperty("key2"));
    }

    /**
     *  用于测试:用户自定义类型成员变量的赋值
     */
    @Test
    public void test11() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        userService.register(new User("suns", "123456"));
        userService.login("xiaohei", "999999");
    }

    /**
     *  用于测试:用于测试构造注入
     */
    @Test
    public void test12() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);
    }

    /**
     *  用于测试:用于测试FactoryBean接口
     */
    @Test
    public void test13() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection connection = (Connection) ctx.getBean("conn");
        Connection connection2 = (Connection) ctx.getBean("conn");

        System.out.println(connection);
        System.out.println(connection2);

    }

    /**
     *  用于测试:用于测试FactoryBean接口
     */
    @Test
    public void test14() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ConnectionFactoryBean connection = (ConnectionFactoryBean) ctx.getBean("&conn");//获取原始对象
        System.out.println(connection);
    }

    /**
     *  用于测试:用于测试实例工厂
     */
    @Test
    public void test15() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println(conn);

    }

    /**
     *  用于测试:用于测试静态工厂
     */
    @Test
    public void test16() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println(conn);

    }

    /**
     *  用于测试:用于测试简单对象创建次数
     */
    @Test
    public void test17() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account account1 = (Account) ctx.getBean("account");
        Account account2 = (Account) ctx.getBean("account");

        System.out.println(account1);
        System.out.println(account2);

    }

    /**
     *  用于测试:用于测试生命周期
     */
    @Test
    public void test18() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Product product = (Product) ctx.getBean("product");

    }
}
