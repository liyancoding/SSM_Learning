package com.ly.spring.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BookShop {

	private List<Book> list;
	private Map<String, Book> map;
	private Properties properties;

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public Map<String, Book> getMap() {
		return map;
	}

	public void setMap(Map<String, Book> map) {
		this.map = map;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "BookShop [list=" + list + ", map=" + map + ", properties=" + properties + "]";
	}

}
