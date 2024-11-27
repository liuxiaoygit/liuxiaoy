package com.yuan.exception;
 
public class MyException extends RuntimeException{
    // 使用时传入错误信息
    public MyException(String msg) {
        super(msg);
    }
}