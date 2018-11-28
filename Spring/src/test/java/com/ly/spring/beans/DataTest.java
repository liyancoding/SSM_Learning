package com.ly.spring.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 10:08 2018/10/23
 * @Modified By:
 */
public class DataTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testConnection() throws SQLException {
        DataSource dataSource = (DataSource) ioc.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
