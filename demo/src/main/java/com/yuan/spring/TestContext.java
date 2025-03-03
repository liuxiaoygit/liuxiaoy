package com.yuan.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestContext {


    @Autowired
    private ApplicationContext context;

    @RequestMapping("/test")
    public String test(){
        TestService bean = context.getBean(TestService.class);
        return bean.test();
    }
}
