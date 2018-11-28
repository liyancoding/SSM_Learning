package com.ly.spring.beans;

public class Student {

	private String name;

	public Student() {
		System.out.println("Student对象被创建了……");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

}
