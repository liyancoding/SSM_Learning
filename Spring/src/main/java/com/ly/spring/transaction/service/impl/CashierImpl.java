package com.ly.spring.transaction.service.impl;

import com.ly.spring.transaction.service.BookShopService;
import com.ly.spring.transaction.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 15:46 2018/11/27
 * @Modified By:
 */
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Transactional
    @Override
    public void checkout(int userId, List<String> isbns) {
        for (String isbn : isbns) {
            // 调用BookShopService中的purchase()方法结账
            bookShopService.purchase(userId,isbn );
        }
    }
}
