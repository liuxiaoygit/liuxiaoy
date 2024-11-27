package com.yuan.exception;
 

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
 
@Slf4j
@RestControllerAdvice
@Primary
public class MyExceptionAdvice {
 
    /**
     * 自定义异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    public RespInfo bizExceptionHandler(MyException ex) {
        log.error("自定义业务异常： ", ex);
        return RespInfo.fail(RespCodeEnums.BIZ_EXCEPTION.getCode(), ex.getMessage());
    }
}