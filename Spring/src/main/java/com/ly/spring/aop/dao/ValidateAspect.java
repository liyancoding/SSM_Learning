package com.ly.spring.aop.dao;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(100) //通过@Order注解指定切面的优先级，value值越小优先级越高，value的默认值是Integer的最大值
@Component
@Aspect
public class ValidateAspect {

	@Before("execution(* com.ly.spring.aop.dao.ArithmeticCalculator.*(..))")
	public void beforeValidate() {
		System.out.println("正在验证……");
	}
}
