package com.ly.spring.beans;

import com.ly.spring.spring03.t.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 15:20 2018/10/30
 * @Modified By:
 */
public class TTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring03.xml");

    @Test
    public void test() {
        UserService userService = (UserService) ioc.getBean("userService");
        userService.save();
    }
}
