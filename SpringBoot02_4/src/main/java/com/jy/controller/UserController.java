package com.jy.controller;

import com.jy.entity.User;
import com.jy.service.UserService;
import com.jy.utils.VerifyCodeUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"code","user"})
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @RequestMapping("login")
    public String login(String username,String password,Model model){
        log.debug(username,password);
        try {
            User user = userService.login(username,password);
            model.addAttribute("user",user);
        } catch (Exception e) {
            return "redirect:/login.jsp?msg=" + URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8);
        }
        return "redirect:/employee/list";
    }

    @RequestMapping("register")
    public String register(User user, String code, Model model) throws UnsupportedEncodingException {
        log.info("接收验证码{}:", code);
        log.info("user{}:", user);
        try {
            String sessionCode = Objects.requireNonNull(model.getAttribute("code")).toString();
            if (!sessionCode.equalsIgnoreCase(code)) throw new RuntimeException("验证码输入错误");
            userService.register(user);
        } catch (RuntimeException e) {
            return "redirect:/regist.jsp?msg=" + URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8);
        }
        return "redirect:/login.jsp";
    }


    @RequestMapping("generateImagCode")
    public void generateImagCode(Model model, HttpServletResponse response) throws IOException {
        //生成随机字符串
        String code = VerifyCodeUtils.generateVerifyCode(4);
        model.addAttribute("code", code);
        response.setContentType("image/png");
        VerifyCodeUtils.outputImage(200, 80, response.getOutputStream(), code);
    }

}
