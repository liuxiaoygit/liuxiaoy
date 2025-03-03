package com.yuan.spring.startload;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // 这里是需要在 Spring 启动时自动执行的方法
        System.out.println("Spring 应用启动完成，执行 CommandLineRunner 方法");
    }
}
