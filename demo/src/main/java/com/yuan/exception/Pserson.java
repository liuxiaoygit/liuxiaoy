package com.yuan.exception;


import lombok.Data;

@Data
public class Pserson {

    private String nameEn;

    public Pserson() {
        System.out.println("父类构造函数执行了");
    }
}
