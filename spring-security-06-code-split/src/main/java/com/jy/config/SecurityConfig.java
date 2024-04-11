package com.jy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jy.security.filter.LoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("{noop}123").roles("ADMIN").build());
        return manager;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //配置自定义filter
    @Bean
    public LoginFilter loginFilter() throws Exception {
        LoginFilter filter = new LoginFilter();
        filter.setFilterProcessesUrl("/doLogin");
        filter.setKaptchaParameter("kaptcha");
        filter.setPasswordParameter("password");
        //指定认证管理器
        filter.setAuthenticationManager(authenticationManagerBean());
        //指定成功时的处理
        filter.setAuthenticationSuccessHandler((req, resp, auth) -> {
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("msg", "登录成功");
            result.put("用户信息", auth.getPrincipal());
            resp.setContentType("application/json;charset=UTF-8");
            resp.setStatus(HttpStatus.OK.value());
            String s = new ObjectMapper().writeValueAsString(result);
            resp.getWriter().println(s);
        });
        //指定失败时的处理
        filter.setAuthenticationFailureHandler((req, resp, ex) -> {
                    Map<String, Object> result = new HashMap<String, Object>();
                    result.put("msg", "登录失败: " + ex.getMessage());
                    resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                    resp.setContentType("application/json;charset=UTF-8");
                    String s = new ObjectMapper().writeValueAsString(result);
                    resp.getWriter().println(s);
        });
        return filter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .mvcMatchers("/vc.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((req, resp, auth) -> {
                    resp.setContentType("application/json;charset=UTF-8");
                    resp.setStatus(HttpStatus.UNAUTHORIZED.value());
                    resp.getWriter().println("请认证");
                })
                .and()
                .logout()
                .and()
                .csrf().disable();

        http.addFilterAt(loginFilter(), LoginFilter.class);
    }
}
