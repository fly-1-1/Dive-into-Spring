package com.jy.security.excepetion;


import org.springframework.security.core.AuthenticationException;

public class KaptchaNotMatchException extends AuthenticationException {



    public KaptchaNotMatchException(String detail) {
        super(detail);
    }

    public KaptchaNotMatchException(String detail, Throwable ex) {
        super(detail, ex);
    }
}
