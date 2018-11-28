package com.ly.spring.annotation.dao.impl;

import com.ly.spring.annotation.beans.User;
import com.ly.spring.annotation.dao.UserDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

//@Repository(value="userDao")//通过value属性指定在IOC容器中的配置的bean的id属性值;value属性名可以省略
@Repository("userDao2")
//@Scope("prototype") //通过@Scope注解告诉Spring的IOC容器该bean需要是多例的
public class UserDaoImpl2 implements UserDao {

	@Override
	public void saveUser(User user) {
		System.out.println("UserDaoImpl2正在向数据库中插入User对象");
	}

}
