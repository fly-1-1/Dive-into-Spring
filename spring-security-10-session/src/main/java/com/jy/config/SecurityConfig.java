package com.jy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .csrf().disable()
                .sessionManagement()
                .maximumSessions(1)
                //.expiredUrl("/login");//用户被挤下线是跳转页面
                .expiredSessionStrategy(event->{
                    HttpServletResponse response = event.getResponse();
                    Map<String, Object> result = new HashMap<>();
                    result.put("status", 500);
                    result.put("msg", "当前会话已经失效,请重新登录!");
                    String s = new ObjectMapper().writeValueAsString(result);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().println(s);
                    response.flushBuffer();
                })
                .sessionRegistry(sessionRegistry()) //session交给谁管理
                .maxSessionsPreventsLogin(true);//用户达到最大会话数时是否阻止登录 只有主动退出登陆才可以再次登录

    }

    private final FindByIndexNameSessionRepository findByIndexNameSessionRepository;

    @Autowired
    public SecurityConfig(FindByIndexNameSessionRepository findByIndexNameSessionRepository) {
        this.findByIndexNameSessionRepository = findByIndexNameSessionRepository;
    }

    //创建 session 同步到 redis 中方案
    @Bean
    public SpringSessionBackedSessionRegistry sessionRegistry() {
        return new SpringSessionBackedSessionRegistry(findByIndexNameSessionRepository);
    }
}
