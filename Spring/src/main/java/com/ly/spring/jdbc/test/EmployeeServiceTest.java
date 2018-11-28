package com.ly.spring.jdbc.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ly.spring.jdbc.beans.Employee;
import com.ly.spring.jdbc.service.EmployeeService;

class EmployeeServiceTest {

	// 创建IOC容器对象
	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-jdbc.xml");

	@Test
	void test() {
		EmployeeService employeeService = (EmployeeService) ioc.getBean("employeeService");
		List<Employee> employees = employeeService.getEmployees();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
