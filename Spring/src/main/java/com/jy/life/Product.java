package com.jy.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.SQLOutput;

public class Product implements InitializingBean , DisposableBean {

    public Product() {
        System.out.println("Product.Product");
    }

    public void myInit(){
        System.out.println("Product.myInit");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Product.destroy");
    }


    public void MyDestroy() throws Exception {
        System.out.println("Product.MyDestroy");
    }

    /**
     * 初始化方法,Spring调用
     *
     * @throws Exception 例外
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product.afterPropertiesSet");
    }
}
