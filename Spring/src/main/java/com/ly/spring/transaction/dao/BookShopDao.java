package com.ly.spring.transaction.dao;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 14:30 2018/11/27
 * @Modified By:
 */
public interface BookShopDao {

    /**
     * 根据书号获取图书的价格
     * @param isbn
     * @return
     */
    public double getBookPrice(String isbn);

    /**
     * 根据书号更新图书的库存，默认一次只能买一本
     * @param isbn
     */
    public void updateBookStock(String isbn);

    /**
     * 根据图书的价格，更新用户账户的余额
     * @param userId
     * @param bookPrice
     */
    public void updateAccount(int userId, double bookPrice);
}
