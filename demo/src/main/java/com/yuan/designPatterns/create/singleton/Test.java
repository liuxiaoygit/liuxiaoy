package com.yuan.designPatterns.create.singleton;

public class Test {
    public static void main(String[] args) {
        Single instance = Single.getInstance();
        instance.say();
    }

}
