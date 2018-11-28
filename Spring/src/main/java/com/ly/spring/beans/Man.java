package com.ly.spring.beans;

public class Man {

	private String name;

	public Man() {
		System.out.println("男人被创建了……");
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Man [name=" + name + "]";
	}

}
