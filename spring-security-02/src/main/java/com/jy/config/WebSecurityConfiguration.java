package com.jy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private  MyUserDetailsService myUserDetailsService;

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        userDetailsService.createUser(User.withUsername("aaa").password("{noop}123456").roles("ADMIN").build());
        return userDetailsService;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    //暴露出AuthenticationManager
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
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
                //.failureUrl("/login") //redirect
                .failureHandler(new MyAuthenticationFailureHandler())//
                .and()
                .logout()
                //.logoutUrl("/logout") //指定注销登陆url
                .logoutRequestMatcher(new OrRequestMatcher(
                        new AntPathRequestMatcher("/aa", "GET"),
                        new AntPathRequestMatcher("/bb", "POST")
                ))
                .invalidateHttpSession(true) //默认 会话失败
                .clearAuthentication(true) //清除 认证标记
                //.logoutSuccessUrl("/login") //注销登陆跳转登陆界面
                .logoutSuccessHandler(new MyLogoutSuccessHandler())
                .and().csrf().disable();
    }

}
