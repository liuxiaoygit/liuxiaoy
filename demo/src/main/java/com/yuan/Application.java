package com.yuan;

import com.yuan.designPatterns.structure.proxy.agent.RegisterBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RegisterBeanFactory registerBeanFactory(){
       return new RegisterBeanFactory();
    }
}
