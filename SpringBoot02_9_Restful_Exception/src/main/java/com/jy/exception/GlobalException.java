package com.jy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException  {

    @ExceptionHandler(value = Exception.class)
    //用在方法上 作用:用来处理指定的异常 value:用来指定用来处理异常的类型
    @ResponseBody
    public ResponseEntity<String> exceptionHandler(Exception e){
        System.out.println("进入自定义异常处理");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = IllegalNumberException.class)
    @ResponseBody
    public ResponseEntity<String> illegalNumberExceptionHandler(Exception e){
        System.out.println("进入非法参数异常处理");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
