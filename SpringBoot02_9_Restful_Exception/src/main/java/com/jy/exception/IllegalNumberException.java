package com.jy.exception;

//自定义异常
public class IllegalNumberException extends RuntimeException{

    public IllegalNumberException(String message) {
        super(message);
    }
}
