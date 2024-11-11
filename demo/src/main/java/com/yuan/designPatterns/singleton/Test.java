package com.yuan.designPatterns.singleton;

public class Test {
    public static void main(String[] args) {
        Single instance = Single.getInstance();
        instance.say();
    }

}
