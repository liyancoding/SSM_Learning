package com.ly.spring.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 19:50 2018/10/18
 * @Modified By:
 */
public class BookTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testSetter() {
        Book book = (Book) ioc.getBean("book");
        System.out.println(book);
    }

    @Test
    public void testConstructor() {
        Book book = (Book) ioc.getBean("book4");
        System.out.println(book);
    }

    @Test
    public void testCartItem() {
        CartItem cartItem = (CartItem) ioc.getBean("cartItem");
        System.out.println(cartItem);
    }

    @Test
    public void testBookShop() {
        BookShop bookShop = (BookShop) ioc.getBean("bookShop");
        System.out.println(bookShop);
    }
}
