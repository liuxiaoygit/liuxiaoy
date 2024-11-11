package com.yuan.designPatterns.singleton;

public class Single {

    private Single() {
    }

    /**
     * 类加载过程
     *  1、开辟空间
     *  2、初始化空间
     *  3、赋值
     *  如果不用volite修饰 步骤2和3可能会颠倒，那么线程获取到的实例可能是不完整的实例
     *  如果不用volite修饰 步骤2和3可能会颠倒，那么线程获取到的实例可能是不完整的实例
     */
    private static volatile Single instance;

    public void say() {
        System.out.println("hello");
    }

    public static Single getInstance() {
        if (instance == null) {
            synchronized (Single.class) {
                if (instance == null) {
                    instance = new Single();
                }
            }
        }
        return instance;
    }
}
