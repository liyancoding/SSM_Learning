package com.ly.spring.helloworld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 13:55 2018/10/18
 * @Modified By:
 */
public class HelloWorldTest {

    @Test
    public void sayHello_Test() {

        /*
        没有Spring之前
         */
        // 1、创建HelloWorld对象
//        HelloWorld helloWorld = new HelloWorld();

        // 2、给helloWorld对象name属性赋值
//        helloWorld.setName("Spring");

        // 3、调用sayHello()方法
//        helloWorld.sayHello();

        /*
        有Spring之后
         */
        // 1、创建IOC容器对象
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2、从IOC容器中获取HelloWorld对象
        // 根据bean的名字（id属性值）获取bean（建议使用）
        HelloWorld helloWorld = (HelloWorld) ioc.getBean("helloWorld");
        // 根据bean的类型获取（不建议使用），要保证该类型的bean在IOC容器中只有一个，否则会抛出异常
//        HelloWorld helloWorld = ioc.getBean(HelloWorld.class);

        // 3、调用sayHello()方法
        helloWorld.sayHello();
    }
}
