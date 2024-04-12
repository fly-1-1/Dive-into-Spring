package com.jy.config;

import org.springframework.core.log.LogMessage;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.http.HttpServletRequest;

public class MyPersistentTokenBasedRememberMeServices extends PersistentTokenBasedRememberMeServices {

    public MyPersistentTokenBasedRememberMeServices(String key, UserDetailsService userDetailsService, PersistentTokenRepository tokenRepository) {
        super(key, userDetailsService, tokenRepository);
    }

    @Override
    protected boolean rememberMeRequested(HttpServletRequest request, String parameter) {
        String paramValue = request.getAttribute(parameter).toString();

        return paramValue == null || !paramValue.equalsIgnoreCase("true") && !paramValue.equalsIgnoreCase("on")
                && !paramValue.equalsIgnoreCase("yes") && !paramValue.equals("1");
    }
}
