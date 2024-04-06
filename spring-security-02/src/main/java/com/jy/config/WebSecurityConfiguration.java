package com.jy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .usernameParameter("uname")
                //.successForwardUrl("/hello")
                //.defaultSuccessUrl("/hello") // 重定向跳转 根据上次保存的页面跳转
                .successHandler(new MyAuthenticationSuccessHandler()) //前后端分离 认证成功方案
                //.failureForwardUrl("/login") //forward
                .failureUrl("/login") //redirect
                .and()
                .csrf()
                .disable()
                .build();
    }

}
