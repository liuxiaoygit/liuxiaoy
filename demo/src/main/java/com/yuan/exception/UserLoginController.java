package com.yuan.exception;
 

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserLoginController {

    static {
        System.out.println("UserLoginController 静态代码块");
    }

    @PostConstruct
    public void init() {
        System.out.println("UserLoginController PostConstruct");
    }

    @GetMapping("/test")
    public User testLogin() throws MyException {
        throw new MyException("测试自定义异常"); // 主动抛出异常
    }
 
    @PostMapping("/add")
    public User addUser(@RequestBody @Validated User user) {
        return user;
    }
 
    @GetMapping("/haha")
    public Object haha() {
        int i = 1 / 0;
        return "haha";
    }
}