package com.ly.spring.aop.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ly.spring.aop.dao.ArithmeticCalculator;


class AOPTest {
	
	// 创建IOC容器对象
	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-aop.xml");

	@Test
	public void test() {
		ArithmeticCalculator acc = (ArithmeticCalculator) ioc.getBean("arithmeticCalculator");
		// 加
		int add = acc.add(10, 2);
		System.out.println(add);
		// 减
		int sub = acc.sub(10, 2);
		System.out.println(sub);
		// 乘
		int mul = acc.mul(10, 2);
		System.out.println(mul);
		// 除
		int div = acc.div(10, 2);
		System.out.println(div);
	}

}
