package com.ly.spring.helloworld;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 13:53 2018/10/18
 * @Modified By:
 */
public class HelloWorld {
    public String name;

    public HelloWorld() {
        System.out.println("HelloWorld对象被创建。。。");
    }

    public void setName(String name) {
        System.out.println("setName()方法被调用。。。");
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello : " + name);
    }
}
