package com.yuan.designPatterns.create.prototype;

/**
 *  原型模式 其实就是复制对象  用在一个对象属性固定，需要克隆很多嘻嘻的场景
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();
        System.out.println("p1.loc == p2.loc? " + (p1.loc == p2.loc));

        p1.loc.street.reverse();
        System.out.println(p2.loc.street);
    }

}
