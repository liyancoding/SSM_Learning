package com.ly.spring.transaction.service;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 15:07 2018/11/27
 * @Modified By:
 */
public interface BookShopService {

    /**
     * 买东西
     * @param userId
     * @param isbn
     */
    public void purchase(int userId, String isbn);
}
