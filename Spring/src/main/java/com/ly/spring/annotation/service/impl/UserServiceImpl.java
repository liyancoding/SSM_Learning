package com.ly.spring.annotation.service.impl;

import com.ly.spring.annotation.beans.User;
import com.ly.spring.annotation.dao.UserDao;
import com.ly.spring.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service("userService")

public class UserServiceImpl implements UserService {
	
	/*
	 * @Autowired自动注入的步骤：
	 * 		1.根据属性的类型及IOC容器中bean的类型进行自动注入
	 * 		2.如果根据属性的类型不能实现自动注入，则以属性的属性名作为id从IOC容器中查找
	 * 		3.如果通过1和2都不能实现自动注入，我们可以通过@Qualifier注解将哪个实现注入进来
	 */
	
	@Qualifier(value = "userDao2") //通过value属性来指定要注入的实现的id属性值
	@Autowired
	private UserDao userDao;

	// 我们还可以通过以下方式实现自动注入（不建议使用）
	@Autowired
	public void setUserDao(@Qualifier(value="userDao1")UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired(required = false) // 通过required=false来告诉Spring当前属性不是必须的
	private User user;

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

}
