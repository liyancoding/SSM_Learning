package com.ly.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 14:13 2018/10/19
 * @Modified By:
 */
public class Test {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @org.junit.Test
    public void testStudent() {
        Student student = (Student) ioc.getBean("student");
        Student student1 = (Student) ioc.getBean("student");
        System.out.println(student == student1);
    }

    @org.junit.Test
    public void testBeanLife() {
        BeanLife beanLife = (BeanLife) ioc.getBean("beanLife");
        System.out.println("beanLife对象可以使用了");
        // 关闭IOC容器
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) ioc;
        configurableApplicationContext.close();
    }

    @org.junit.Test
    public void testMyBeanPostProcessor() {
        MyBeanPostProcessor myBeanPostProcessor = (MyBeanPostProcessor) ioc.getBean("beanPostProcessor");
        System.out.println("myBeanPostProcessor");
    }

    @org.junit.Test
    public void testStaticFactory() {
        Book book = (Book) ioc.getBean("staticFactory");
        System.out.println(book);
    }

    @org.junit.Test
    public void testInstanceFactory() {
        Book book = (Book) ioc.getBean("book5");
        System.out.println(book);
    }

    @org.junit.Test
    public void testMyFactoryBean() {
        Book book = (Book) ioc.getBean("myFactoryBean");
        System.out.println(book);
    }
}
