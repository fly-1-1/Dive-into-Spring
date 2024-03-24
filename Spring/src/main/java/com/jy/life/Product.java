package com.jy.life;

import org.springframework.beans.factory.InitializingBean;

import java.sql.SQLOutput;

//public class Product implements InitializingBean {
public class Product {
    public Product() {
        System.out.println("Product.Product");
    }

    public void myInit(){
        System.out.println("Product.myInit");
    }


//    /**
//     * 初始化方法,Spring调用
//     *
//     * @throws Exception 例外
//     */
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Product.afterPropertiesSet");
//    }
}
