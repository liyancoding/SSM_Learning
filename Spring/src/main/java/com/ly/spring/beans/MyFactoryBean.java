package com.ly.spring.beans;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Book> {

	@Override
	public Book getObject() throws Exception {
		return new Book(1, "SSM从SSM到SM", "肖东", 7.77, 1000000);
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
