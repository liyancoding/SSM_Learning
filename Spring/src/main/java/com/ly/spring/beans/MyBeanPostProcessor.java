package com.ly.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 创建Bean的后置处理器
 * 
 * @author hanya
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("在初始化方法之前调用");
		System.out.println("传入的对象是："+bean);
		System.out.println("bean的名字是："+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("在初始化方法之后调用");
		return bean;
	}

	

}
