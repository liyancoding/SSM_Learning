package com.ly.spring.transaction.test;

import com.ly.spring.transaction.dao.BookShopDao;
import com.ly.spring.transaction.service.BookShopService;
import com.ly.spring.transaction.service.Cashier;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 14:26 2018/11/27
 * @Modified By:
 */
public class TransactionTest {

    // 创建IOC容器
//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-transaction.xml");
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-transaction.xml");

    @Test
    void testConnection() throws SQLException {
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    void testIsolation() {
        BookShopService bookShopService = (BookShopService) applicationContext.getBean("bookShopService");
        bookShopService.purchase(1, "1001");
    }

    @Test
    void testBookShopDao() {
        BookShopDao bookShopDao = (BookShopDao) applicationContext.getBean("bookShopDao");

        // 获取图书的价格
        double bookPrice = bookShopDao.getBookPrice("1001");
        System.out.println(bookPrice);

        // 更新图书的库存
        bookShopDao.updateBookStock("1001");

        // 更新个人账户
        bookShopDao.updateAccount(1, bookPrice);
    }

    @Test
    void testPurchase() {
        BookShopService bookShopService = (BookShopService) applicationContext.getBean("bookShopService");
        bookShopService.purchase(1, "1002");
    }

    @Test
    void testCashier() {
        Cashier cashier = (Cashier) applicationContext.getBean("cashier");
        List<String> isbns = new ArrayList<>();
        isbns.add("1001");
        isbns.add("1002");
        cashier.checkout(1, isbns);
    }
}
