package com.yuan.spring;


import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String test() {
        return "test";
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(n |= n >> 1);
        System.out.println(n |= n >> 2);
        System.out.println(n |= n >> 4);
        System.out.println(n |= n >> 8);
        System.out.println(n |= n >> 16);

    }
}
