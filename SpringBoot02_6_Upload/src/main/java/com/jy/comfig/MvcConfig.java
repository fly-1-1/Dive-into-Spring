package com.jy.comfig;

import com.jy.interceptors.Interceptor1;
import com.jy.interceptors.Interceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor1()).addPathPatterns("/**").excludePathPatterns("/file/**").order(2);

        registry.addInterceptor(new Interceptor2()).addPathPatterns("/**").excludePathPatterns("/file/**").order(1);


    }
}
