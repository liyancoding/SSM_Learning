package com.ly.spring.beans;


import com.ly.spring.spring03.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 14:34 2018/10/30
 * @Modified By:
 */
public class Spring03Test {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring03.xml");

    @Test
    public void test() {
        UserService userService = (UserService) ioc.getBean("userService");
        userService.saveUser();
    }

}
