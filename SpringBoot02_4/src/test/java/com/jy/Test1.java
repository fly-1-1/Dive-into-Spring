package com.jy;

import com.jy.utils.VerifyCodeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;

@SpringBootTest
public class Test1 {

    @Test
    void Test01()  {
        String string = VerifyCodeUtils.generateVerifyCode(4);
        System.out.println(string);
        try {
            VerifyCodeUtils.outputImage(200,80,new FileOutputStream(new File("D:\\aa.png")), string);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
