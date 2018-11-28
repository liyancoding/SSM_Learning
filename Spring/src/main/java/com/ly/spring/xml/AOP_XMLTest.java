package com.ly.spring.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class AOP_XMLTest {

	// 创建IOC容器对象
	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-xml.xml");

	@Test
	void test() {
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
		int div = acc.div(10, 0);
		System.out.println(div);
	}
}
