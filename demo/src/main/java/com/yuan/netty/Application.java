package com.yuan.netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private NettyClient nettyClient;

    @Override
    public void run(String... args) throws Exception {
        nettyClient.start();
    }
}