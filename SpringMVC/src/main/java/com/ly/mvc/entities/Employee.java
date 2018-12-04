package com.ly.mvc.entities;

public class Employee {

	private Integer id;
	private String lastName;
	private String email;
	private double salary;
	private Department dept;
	
	public Employee() {
		System.out.println("Employee被创建了");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		System.out.println("setId方法被调用了");
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", salary=" + salary + ", dept="
				+ dept + "]";
	}

}
