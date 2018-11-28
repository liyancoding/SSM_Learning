package com.ly.spring.transaction.service.impl;

import com.ly.spring.transaction.dao.BookShopDao;
import com.ly.spring.transaction.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 15:09 2018/11/27
 * @Modified By:
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    /**
     * 事务的属性
     * 1） propagation：用来设置事务的传播行为
     *        事务的传播行为：一个方法运行在一个开启了事务的方法中时，当前方法是使用原有的事务还是开启一个新的事务？？？
     *              ---Propagation.REQUIRED：默认值，使用原来的事务
     *              ---Propagation.REQUIRES_NEW：开启一个新的事务
     * 2） isolation：用来设置事务的隔离级别
     *              ---Isolation.READ_UNCOMMITTED
     *              ---Isolation.READ_COMMITTED（避免脏读）：读已提交，Oracle默认的隔离级别
     *              ---Isolation.REPEATABLE_READ（避免不可重复读）：可重复读，MySQL默认隔离级别
     *              ---Isolation.SERIALIZABLE（避免幻读）
     * 3） rollbackFor：用来设置哪些异常回滚，值是异常的类型
     *     rollbackForClassName：用来设置哪些异常回滚，值是异常的名字
     *     noRollbackFor：用来设置哪些异常不回滚，值是异常的类型
     *     noRollbackForClassName：用来设置哪些异常不回滚，值是异常的名字
     * 4） readOnly：用来设置只读属性。通常情况下，如果是一个查询的操作，那么该属性值设置为true
     * 5） timeout：用来设置超时的时间
     */
    // 该注解可以添加到类上，也可以添加到方法上。如果添加到类上，那么类中的方法都将添加事务
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ,
            noRollbackForClassName = "ArithmeticException",readOnly = false,timeout = 3)
    @Override
    public void purchase(int userId, String isbn) {

        // 让线程睡眠4s
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // 获取图书的价格
        double bookPrice = bookShopDao.getBookPrice(isbn);
//        System.out.println(bookPrice);
//        bookPrice = bookShopDao.getBookPrice(isbn);
//        System.out.println(bookPrice);

        // 更新图书库存
        bookShopDao.updateBookStock(isbn);
//        int i = 10 / 0;

        // 更新用户账户的余额
        bookShopDao.updateAccount(userId, bookPrice);

    }
}
