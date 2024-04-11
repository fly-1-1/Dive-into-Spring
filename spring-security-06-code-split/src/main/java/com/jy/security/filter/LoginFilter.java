package com.jy.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jy.security.excepetion.KaptchaNotMatchException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    public static final String FORM_KAPTCHA_KEY = "kaptcha";
    private String kaptchaParameter = "FORM_KAPTCHA_KEY";
    public String getKaptchaParameter() {
        return kaptchaParameter;
    }
    public void setKaptchaParameter(String kaptchaParameter) {
        this.kaptchaParameter = kaptchaParameter;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        //获取请求数据
        try {
            Map<String, String> userInfo = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            String kaptcha = userInfo.get(getKaptchaParameter());
            String username = userInfo.get(getUsernameParameter());
            String password = userInfo.get(getPasswordParameter());
            //获取请求验证码
            String sessionKaptcha = (String) request.getSession().getAttribute("kaptcha");
            if (!ObjectUtils.isEmpty(sessionKaptcha) && !ObjectUtils.isEmpty(kaptcha) && kaptcha.equalsIgnoreCase(sessionKaptcha)) {
                //获取用户名 密码认证
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        throw new KaptchaNotMatchException("验证码不匹配");
    }
}
