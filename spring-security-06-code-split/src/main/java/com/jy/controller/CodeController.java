package com.jy.controller;

import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class CodeController {

    private final Producer producer;

    @Autowired
    public CodeController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("vc.jpg")
    public String hello(HttpSession session) throws IOException {
        //生成验证码
        String text = producer.createText();
        System.out.println(text);
        //放入session redis
        session.setAttribute("kaptcha", text);
        //生成图片
        BufferedImage image = producer.createImage(text);
        //图片转为byte数组
        FastByteArrayOutputStream fos = new FastByteArrayOutputStream();
        ImageIO.write(image, "jpg", fos);
        //返回base64编码的图片
        return Base64.encodeBase64String(fos.toByteArray());

    }

}
