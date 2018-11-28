package com.ly.spring.transaction.dao.impl;

import com.ly.spring.transaction.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 14:35 2018/11/27
 * @Modified By:
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public double getBookPrice(String isbn) {
        // 写sql语句
        String sql = "select price from book where isbn = ?";

        Double bookPrice = jdbcTemplate.queryForObject(sql, Double.class, isbn);

        return bookPrice;
    }

    @Override
    public void updateBookStock(String isbn) {

        // 默认一次只能买一本，所以是stock = stock - 1
        String sql = "update book_stock set stock = stock - 1 where isbn = ?";

        jdbcTemplate.update(sql, isbn);

    }

    @Override
    public void updateAccount(int userId, double bookPrice) {

        String sql = "update account set balance = balance - ? where id = ?";

        jdbcTemplate.update(sql, bookPrice, userId);
    }
}
