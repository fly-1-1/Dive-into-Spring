package com.jy.Excepetion;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GlobalException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("全局异常处理");
        System.out.println("当前异常为:"+ex);
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof UserNameNotFoundException){
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.setViewName("500");
        return modelAndView;
    }
}
