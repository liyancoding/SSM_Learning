package com.ly.spring.beans;

public class Woman {

	private String name;

	public Woman() {
		System.out.println("女人被创建了……");
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Woman [name=" + name + "]";
	}

}
