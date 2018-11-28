package com.ly.spring.beans;

import com.ly.spring.annotation.beans.User;
import com.ly.spring.annotation.dao.UserDao;
import com.ly.spring.annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 10:17 2018/10/29
 * @Modified By:
 */
public class AnnotationTest {

    // 创建IOC容器对象
//    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-annotation.xml");

    // 整合多个配置文件
    // 方式一：使用通配符
//    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-*");

    // 方式二：直接在创建IOC容器时传入多个配置文件
//    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-annotation.xml", "beans-db.xml", "beans-jdbc.xml");

    // 方式三：选择一个主配置文件，然后将其他配置文件通过importa标签引入到主文件中
    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-annotation.xml");

    @Test
    public void testUser() {
        UserDao userDao = (UserDao) ioc.getBean("userDao");
        UserDao userDao1 = (UserDao) ioc.getBean("userDao");
        // 表明是单例的
        System.out.println(userDao==userDao1);
    }

    @Test
    public void testUserService() {
        UserService userService = (UserService) ioc.getBean("userService");
        // 创建User对象
        User user = new User();
        userService.saveUser(user);
    }
}
