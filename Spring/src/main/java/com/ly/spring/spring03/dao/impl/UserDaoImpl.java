package com.ly.spring.spring03.dao.impl;

import com.ly.spring.spring03.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 14:28 2018/10/30
 * @Modified By:
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {


    @Override
    public void saveUser() {
        System.out.println("正在向数据库中保存用户");
    }
}
