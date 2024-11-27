package com.yuan.exception;
 
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
 
import java.util.Objects;
 
@Slf4j
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE - 2) // 异常处理器顺序，越小越优先，-2保证比全局更优先
public class ArgumentsValidateAdvice {
 
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RespInfo methodArgsNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        log.error("参数异常，msg ->", ex);
        return RespInfo.fail(RespCodeEnums.PARAMS_NOT_VALID_ERROR.getCode(), Objects.requireNonNull(ex.getBindingResult().getFieldError().getDefaultMessage()));
    }
}