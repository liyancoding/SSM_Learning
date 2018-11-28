package com.ly.spring.beans;

public class Employee {

	private Integer id;
	private String name;
	private Integer age;
	private boolean married;
	private double yearSalary;
	private int houseArea;
	private Department dept;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public double getYearSalary() {
		return yearSalary;
	}

	public void setYearSalary(double yearSalary) {
		this.yearSalary = yearSalary;
	}

	public int getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(int houseArea) {
		this.houseArea = houseArea;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", married=" + married + ", yearSalary="
				+ yearSalary + ", houseArea=" + houseArea + ", dept=" + dept + "]";
	}

	//获取年薪的方法
	public double getSalary(double monthSalary) {
		return 14*monthSalary;
	}
	
	// 获取北京市朝阳区房子的面积
	public static int getHouse() {
		return 150;
	}
}
