package com.jy.security.filters;

import com.jy.security.excepetion.KaptchaNotMatchException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KaptchaFilter extends UsernamePasswordAuthenticationFilter {

    private static final String Form_KANAPTCHA_KEY = "kaptcha";

    private String kaptchaParameter = Form_KANAPTCHA_KEY;

    public void setKaptchaParameter(String kaptchaParameter) {
        this.kaptchaParameter = kaptchaParameter;
    }

    public String getKaptchaParameter() {
        return kaptchaParameter;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        //从请求中获取验证码
        String captcha = request.getParameter(getKaptchaParameter());
        String sessionCode = (String) request.getSession().getAttribute("kaptcha");
        if (!ObjectUtils.isEmpty(captcha) && !ObjectUtils.isEmpty(sessionCode)
                && captcha.equalsIgnoreCase(sessionCode)) {

            return super.attemptAuthentication(request, response);
        }
        throw new KaptchaNotMatchException("验证码错误");
    }
}
