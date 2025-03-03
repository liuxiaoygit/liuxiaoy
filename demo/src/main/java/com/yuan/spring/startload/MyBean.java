package com.yuan.spring.startload;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBean {

    @PostConstruct
    public void init() {
        // 这里是需要在 Spring 启动时自动执行的方法
        System.out.println("MyBean 初始化完成，执行初始化方法");
    }
}
