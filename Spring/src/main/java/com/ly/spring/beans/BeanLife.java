package com.ly.spring.beans;

public class BeanLife {

	private String name;

	public BeanLife() {
		System.out.println("BeanLife对象被创建了");
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("BeanLife对象的name属性被赋值了");
	}

	@Override
	public String toString() {
		return "BeanLife [name=" + name + "]";
	}

	// 初始化时调用的方法
	public void init() {
		System.out.println("BeanLife对象正在被初始化");
	}

	// 销毁时要调用的方法
	public void destory() {
		System.out.println("BeanLife对象被销毁了");
	}
}
