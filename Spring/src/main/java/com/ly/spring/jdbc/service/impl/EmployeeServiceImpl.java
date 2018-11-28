package com.ly.spring.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.spring.jdbc.beans.Employee;
import com.ly.spring.jdbc.dao.EmployeeDao;
import com.ly.spring.jdbc.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

}
