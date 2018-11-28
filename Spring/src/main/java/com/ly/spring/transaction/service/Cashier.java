package com.ly.spring.transaction.service;

import java.util.List;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 15:45 2018/11/27
 * @Modified By:
 */
public interface Cashier {

    /**
     * 去结账
     * @param userId
     * @param isbns
     */
    public void checkout(int userId, List<String> isbns);
}
