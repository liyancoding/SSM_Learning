package com.ly.spring.spring03.service.impl;

import com.ly.spring.spring03.dao.UserDao;
import com.ly.spring.spring03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 14:31 2018/10/30
 * @Modified By:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
