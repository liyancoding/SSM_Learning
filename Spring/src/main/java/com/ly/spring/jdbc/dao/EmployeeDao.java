package com.ly.spring.jdbc.dao;

import java.util.List;

import com.ly.spring.jdbc.beans.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployees();
}
