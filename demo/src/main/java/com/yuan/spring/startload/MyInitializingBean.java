package com.yuan.spring.startload;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyInitializingBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        // 这里是需要在 Spring 启动时自动执行的方法
        System.out.println("MyInitializingBean 初始化完成，执行初始化方法");
    }
}
