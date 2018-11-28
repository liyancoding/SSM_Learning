package com.ly.spring.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过实例工厂方法配置bean
 * 
 * @author hanya
 *
 */
public class InstanceFactory {

	private Map<String, Book> map = new HashMap<>();

	{
		map.put("book01", new Book(1, "Java基础从入门到精通", "李玉婷", 6.66, 10));
		map.put("book02", new Book(2, "MySQL必知必会", "康师傅", 2.22, 100));
		map.put("book03", new Book(3, "JavaWeb从入门到删库", "韩总", 8.88, 1000));
	}

	public Book getBook(String key) {
		return map.get(key);
	}
}
